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
    final /* synthetic */ SquareSearchActivity bmO;
    ArrayList<BasicNameValuePair> bmS;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;

    public ak(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.bmO = squareSearchActivity;
        this.mUrl = null;
        this.bmS = null;
        this.mUrl = str;
        this.bmS = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        com.baidu.tbadk.core.view.o oVar;
        ListView listView;
        ProgressBar progressBar;
        oVar = this.bmO.ahO;
        oVar.setVisibility(8);
        listView = this.bmO.bmq;
        if (listView.getVisibility() != 0) {
            progressBar = this.bmO.mProgress;
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
            Iterator<BasicNameValuePair> it = this.bmS.iterator();
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
                    Iterator<BasicNameValuePair> it2 = this.bmS.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.bmO.bmC = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.bmO.bmD = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.yV.mc().nb().jq()) {
                    str = this.bmO.bmA;
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
        progressBar = this.bmO.mProgress;
        progressBar.setVisibility(8);
        eVar = this.bmO.bmt;
        eVar.setRefreshing(0);
        eVar2 = this.bmO.bmt;
        eVar2.notifyDataSetChanged();
        if (searchPostModel == null || this.yV == null || !this.yV.mc().nb().mf()) {
            this.bmO.showToast(this.bmO.getString(com.baidu.tieba.y.neterror));
        } else if (this.yV.mc().nb().jq()) {
            this.bmO.bmx = searchPostModel;
            eVar3 = this.bmO.bmt;
            eVar3.notifyDataSetChanged();
            this.bmO.refresh();
        } else {
            this.bmO.showToast(this.yV.getErrorString());
        }
        this.bmO.bmz = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        e eVar;
        e eVar2;
        ProgressBar progressBar;
        eVar = this.bmO.bmt;
        eVar.setRefreshing(0);
        eVar2 = this.bmO.bmt;
        eVar2.notifyDataSetChanged();
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        progressBar = this.bmO.mProgress;
        progressBar.setVisibility(8);
        this.bmO.bmz = null;
        super.onCancelled();
    }
}
