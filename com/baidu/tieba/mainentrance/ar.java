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
public class ar extends BdAsyncTask<Object, Integer, PostSuggestModel> {
    private com.baidu.tbadk.core.util.aa ZD = null;
    final /* synthetic */ SquareSearchActivity bzG;
    ArrayList<BasicNameValuePair> bzK;
    private String mUrl;

    public ar(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.bzG = squareSearchActivity;
        this.mUrl = null;
        this.bzK = null;
        this.mUrl = str;
        this.bzK = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ListView listView;
        ProgressBar progressBar;
        listView = this.bzG.bze;
        if (listView.getVisibility() != 0) {
            progressBar = this.bzG.mProgress;
            progressBar.setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public PostSuggestModel doInBackground(Object... objArr) {
        Exception exc;
        PostSuggestModel postSuggestModel;
        String str;
        try {
            this.ZD = new com.baidu.tbadk.core.util.aa(this.mUrl);
            Iterator<BasicNameValuePair> it = this.bzK.iterator();
            while (it.hasNext()) {
                this.ZD.a(it.next());
            }
            String rO = this.ZD.rO();
            if (!this.ZD.sp().tq().ss() || rO == null) {
                return null;
            }
            PostSuggestModel postSuggestModel2 = new PostSuggestModel();
            try {
                postSuggestModel2.parserJson(rO);
                if (rO != null && this.ZD != null && this.ZD.sp().tq().pv()) {
                    Iterator<BasicNameValuePair> it2 = this.bzK.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.bzG.bzo = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.bzG.bzq = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.ZD.sp().tq().pv()) {
                    str = this.bzG.bzm;
                    com.baidu.tieba.tbadkCore.util.j.iL(str);
                    return postSuggestModel2;
                }
                return postSuggestModel2;
            } catch (Exception e) {
                postSuggestModel = postSuggestModel2;
                exc = e;
                BdLog.e(exc.getMessage());
                return postSuggestModel;
            }
        } catch (Exception e2) {
            exc = e2;
            postSuggestModel = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(PostSuggestModel postSuggestModel) {
        ProgressBar progressBar;
        i iVar;
        i iVar2;
        i iVar3;
        progressBar = this.bzG.mProgress;
        progressBar.setVisibility(8);
        iVar = this.bzG.bzg;
        iVar.setRefreshing(0);
        iVar2 = this.bzG.bzg;
        iVar2.notifyDataSetChanged();
        if (postSuggestModel == null || this.ZD == null || !this.ZD.sp().tq().ss()) {
            this.bzG.showToast(this.bzG.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else if (this.ZD.sp().tq().pv()) {
            this.bzG.bzj = postSuggestModel;
            iVar3 = this.bzG.bzg;
            iVar3.notifyDataSetChanged();
            this.bzG.refresh();
        } else {
            this.bzG.showToast(this.ZD.getErrorString());
        }
        this.bzG.bzl = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        i iVar;
        i iVar2;
        ProgressBar progressBar;
        iVar = this.bzG.bzg;
        iVar.setRefreshing(0);
        iVar2 = this.bzG.bzg;
        iVar2.notifyDataSetChanged();
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        progressBar = this.bzG.mProgress;
        progressBar.setVisibility(8);
        this.bzG.bzl = null;
        super.onCancelled();
    }
}
