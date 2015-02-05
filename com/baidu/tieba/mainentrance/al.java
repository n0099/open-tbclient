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
    private com.baidu.tbadk.core.util.ad CU = null;
    final /* synthetic */ SquareSearchActivity bta;
    ArrayList<BasicNameValuePair> bte;
    private String mUrl;

    public al(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.bta = squareSearchActivity;
        this.mUrl = null;
        this.bte = null;
        this.mUrl = str;
        this.bte = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tbadk.core.view.x xVar;
        ListView listView;
        ProgressBar progressBar;
        xVar = this.bta.mNoDataView;
        xVar.setVisibility(8);
        listView = this.bta.bsE;
        if (listView.getVisibility() != 0) {
            progressBar = this.bta.mProgress;
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
            this.CU = new com.baidu.tbadk.core.util.ad(this.mUrl);
            Iterator<BasicNameValuePair> it = this.bte.iterator();
            while (it.hasNext()) {
                this.CU.a(it.next());
            }
            String or = this.CU.or();
            if (!this.CU.oS().qa().oV() || or == null) {
                return null;
            }
            SearchPostModel searchPostModel2 = new SearchPostModel();
            try {
                searchPostModel2.parserJson(or);
                if (or != null && this.CU != null && this.CU.oS().qa().lT()) {
                    Iterator<BasicNameValuePair> it2 = this.bte.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.bta.bsP = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.bta.bsQ = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.CU.oS().qa().lT()) {
                    str = this.bta.bsN;
                    com.baidu.tieba.tbadkCore.util.j.ir(str);
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
        progressBar = this.bta.mProgress;
        progressBar.setVisibility(8);
        eVar = this.bta.bsG;
        eVar.setRefreshing(0);
        eVar2 = this.bta.bsG;
        eVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.CU == null || !this.CU.oS().qa().oV()) {
            this.bta.showToast(this.bta.getPageContext().getString(com.baidu.tieba.z.neterror));
        } else if (this.CU.oS().qa().lT()) {
            this.bta.bsK = searchPostModel;
            eVar3 = this.bta.bsG;
            eVar3.notifyDataSetChanged();
            this.bta.refresh();
        } else {
            this.bta.showToast(this.CU.getErrorString());
        }
        this.bta.bsM = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        e eVar;
        e eVar2;
        ProgressBar progressBar;
        eVar = this.bta.bsG;
        eVar.setRefreshing(0);
        eVar2 = this.bta.bsG;
        eVar2.notifyDataSetChanged();
        if (this.CU != null) {
            this.CU.dJ();
            this.CU = null;
        }
        progressBar = this.bta.mProgress;
        progressBar.setVisibility(8);
        this.bta.bsM = null;
        super.onCancelled();
    }
}
