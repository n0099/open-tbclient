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
    private com.baidu.tbadk.core.util.ad CV = null;
    final /* synthetic */ SquareSearchActivity brF;
    ArrayList<BasicNameValuePair> brJ;
    private String mUrl;

    public al(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.brF = squareSearchActivity;
        this.mUrl = null;
        this.brJ = null;
        this.mUrl = str;
        this.brJ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tbadk.core.view.x xVar;
        ListView listView;
        ProgressBar progressBar;
        xVar = this.brF.mNoDataView;
        xVar.setVisibility(8);
        listView = this.brF.brh;
        if (listView.getVisibility() != 0) {
            progressBar = this.brF.mProgress;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public SearchPostModel doInBackground(Object... objArr) {
        Exception exc;
        SearchPostModel searchPostModel;
        String str;
        try {
            this.CV = new com.baidu.tbadk.core.util.ad(this.mUrl);
            Iterator<BasicNameValuePair> it = this.brJ.iterator();
            while (it.hasNext()) {
                this.CV.a(it.next());
            }
            String ov = this.CV.ov();
            if (!this.CV.oW().pW().oZ() || ov == null) {
                return null;
            }
            SearchPostModel searchPostModel2 = new SearchPostModel();
            try {
                searchPostModel2.parserJson(ov);
                if (ov != null && this.CV != null && this.CV.oW().pW().ma()) {
                    Iterator<BasicNameValuePair> it2 = this.brJ.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.brF.brt = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.brF.bru = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.CV.oW().pW().ma()) {
                    str = this.brF.brr;
                    com.baidu.tieba.tbadkCore.util.j.im(str);
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
        progressBar = this.brF.mProgress;
        progressBar.setVisibility(8);
        eVar = this.brF.brk;
        eVar.setRefreshing(0);
        eVar2 = this.brF.brk;
        eVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.CV == null || !this.CV.oW().pW().oZ()) {
            this.brF.showToast(this.brF.getPageContext().getString(com.baidu.tieba.z.neterror));
        } else if (this.CV.oW().pW().ma()) {
            this.brF.bro = searchPostModel;
            eVar3 = this.brF.brk;
            eVar3.notifyDataSetChanged();
            this.brF.refresh();
        } else {
            this.brF.showToast(this.CV.getErrorString());
        }
        this.brF.brq = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        e eVar;
        e eVar2;
        ProgressBar progressBar;
        eVar = this.brF.brk;
        eVar.setRefreshing(0);
        eVar2 = this.brF.brk;
        eVar2.notifyDataSetChanged();
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        progressBar = this.brF.mProgress;
        progressBar.setVisibility(8);
        this.brF.brq = null;
        super.onCancelled();
    }
}
