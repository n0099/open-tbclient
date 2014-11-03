package com.baidu.tieba.mainentrance;

import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.SearchPostModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Object, Integer, SearchPostModel> {
    final /* synthetic */ SquareSearchActivity bnc;
    ArrayList<BasicNameValuePair> bng;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;

    public ak(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.bnc = squareSearchActivity;
        this.mUrl = null;
        this.bng = null;
        this.mUrl = str;
        this.bng = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tbadk.core.view.o oVar;
        ListView listView;
        ProgressBar progressBar;
        oVar = this.bnc.ahX;
        oVar.setVisibility(8);
        listView = this.bnc.bmE;
        if (listView.getVisibility() != 0) {
            progressBar = this.bnc.mProgress;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public SearchPostModel doInBackground(Object... objArr) {
        Exception exc;
        SearchPostModel searchPostModel;
        String str;
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
            Iterator<BasicNameValuePair> it = this.bng.iterator();
            while (it.hasNext()) {
                this.yV.a(it.next());
            }
            String lA = this.yV.lA();
            if (!this.yV.mc().nb().mf() || lA == null) {
                return null;
            }
            SearchPostModel searchPostModel2 = new SearchPostModel();
            try {
                searchPostModel2.parserJson(lA);
                if (lA != null && this.yV != null && this.yV.mc().nb().jq()) {
                    Iterator<BasicNameValuePair> it2 = this.bng.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.bnc.bmQ = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.bnc.bmR = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.yV.mc().nb().jq()) {
                    str = this.bnc.bmO;
                    com.baidu.tieba.util.j.hA(str);
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
        progressBar = this.bnc.mProgress;
        progressBar.setVisibility(8);
        eVar = this.bnc.bmH;
        eVar.setRefreshing(0);
        eVar2 = this.bnc.bmH;
        eVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.yV == null || !this.yV.mc().nb().mf()) {
            this.bnc.showToast(this.bnc.getString(com.baidu.tieba.y.neterror));
        } else if (this.yV.mc().nb().jq()) {
            this.bnc.bmL = searchPostModel;
            eVar3 = this.bnc.bmH;
            eVar3.notifyDataSetChanged();
            this.bnc.refresh();
        } else {
            this.bnc.showToast(this.yV.getErrorString());
        }
        this.bnc.bmN = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        e eVar;
        e eVar2;
        ProgressBar progressBar;
        eVar = this.bnc.bmH;
        eVar.setRefreshing(0);
        eVar2 = this.bnc.bmH;
        eVar2.notifyDataSetChanged();
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        progressBar = this.bnc.mProgress;
        progressBar.setVisibility(8);
        this.bnc.bmN = null;
        super.onCancelled();
    }
}
