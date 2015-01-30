package com.baidu.tieba.mainentrance;

import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<Object, Integer, SearchPostModel> {
    private com.baidu.tbadk.core.util.ad CX = null;
    final /* synthetic */ SquareSearchActivity btb;
    ArrayList<BasicNameValuePair> btf;
    private String mUrl;

    public al(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.btb = squareSearchActivity;
        this.mUrl = null;
        this.btf = null;
        this.mUrl = str;
        this.btf = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tbadk.core.view.x xVar;
        ListView listView;
        ProgressBar progressBar;
        xVar = this.btb.mNoDataView;
        xVar.setVisibility(8);
        listView = this.btb.bsF;
        if (listView.getVisibility() != 0) {
            progressBar = this.btb.mProgress;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
    public SearchPostModel doInBackground(Object... objArr) {
        Exception exc;
        SearchPostModel searchPostModel;
        String str;
        try {
            this.CX = new com.baidu.tbadk.core.util.ad(this.mUrl);
            Iterator<BasicNameValuePair> it = this.btf.iterator();
            while (it.hasNext()) {
                this.CX.a(it.next());
            }
            String oy = this.CX.oy();
            if (!this.CX.oZ().qh().pc() || oy == null) {
                return null;
            }
            SearchPostModel searchPostModel2 = new SearchPostModel();
            try {
                searchPostModel2.parserJson(oy);
                if (oy != null && this.CX != null && this.CX.oZ().qh().ma()) {
                    Iterator<BasicNameValuePair> it2 = this.btf.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.btb.bsQ = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.btb.bsR = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.CX.oZ().qh().ma()) {
                    str = this.btb.bsO;
                    com.baidu.tieba.tbadkCore.util.j.it(str);
                    return searchPostModel2;
                }
                return searchPostModel2;
            } catch (Exception e) {
                searchPostModel = searchPostModel2;
                exc = e;
                BdLog.e(exc.getMessage());
                return searchPostModel;
            }
        } catch (Exception e2) {
            exc = e2;
            searchPostModel = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(SearchPostModel searchPostModel) {
        ProgressBar progressBar;
        e eVar;
        e eVar2;
        e eVar3;
        progressBar = this.btb.mProgress;
        progressBar.setVisibility(8);
        eVar = this.btb.bsH;
        eVar.setRefreshing(0);
        eVar2 = this.btb.bsH;
        eVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.CX == null || !this.CX.oZ().qh().pc()) {
            this.btb.showToast(this.btb.getPageContext().getString(com.baidu.tieba.z.neterror));
        } else if (this.CX.oZ().qh().ma()) {
            this.btb.bsL = searchPostModel;
            eVar3 = this.btb.bsH;
            eVar3.notifyDataSetChanged();
            this.btb.refresh();
        } else {
            this.btb.showToast(this.CX.getErrorString());
        }
        this.btb.bsN = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        e eVar;
        e eVar2;
        ProgressBar progressBar;
        eVar = this.btb.bsH;
        eVar.setRefreshing(0);
        eVar2 = this.btb.bsH;
        eVar2.notifyDataSetChanged();
        if (this.CX != null) {
            this.CX.dJ();
            this.CX = null;
        }
        progressBar = this.btb.mProgress;
        progressBar.setVisibility(8);
        this.btb.bsN = null;
        super.onCancelled();
    }
}
