package com.baidu.tieba.mainentrance;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, Integer, PostSuggestModel> {
    private com.baidu.tbadk.core.util.aa ZF = null;
    final /* synthetic */ SquareSearchActivity bzT;
    ArrayList<BasicNameValuePair> bzX;
    private String mUrl;

    public aq(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.bzT = squareSearchActivity;
        this.mUrl = null;
        this.bzX = null;
        this.mUrl = str;
        this.bzX = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        BdListView bdListView;
        ProgressBar progressBar;
        bdListView = this.bzT.bzr;
        if (bdListView.getVisibility() != 0) {
            progressBar = this.bzT.mProgress;
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
            this.ZF = new com.baidu.tbadk.core.util.aa(this.mUrl);
            Iterator<BasicNameValuePair> it = this.bzX.iterator();
            while (it.hasNext()) {
                this.ZF.a(it.next());
            }
            String rO = this.ZF.rO();
            if (!this.ZF.sp().tq().ss() || rO == null) {
                return null;
            }
            PostSuggestModel postSuggestModel2 = new PostSuggestModel();
            try {
                postSuggestModel2.parserJson(rO);
                if (rO != null && this.ZF != null && this.ZF.sp().tq().pv()) {
                    Iterator<BasicNameValuePair> it2 = this.bzX.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.bzT.bzB = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.bzT.bzD = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.ZF.sp().tq().pv()) {
                    str = this.bzT.bzz;
                    com.baidu.tieba.tbadkCore.util.j.iO(str);
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
    /* renamed from: a */
    public void onPostExecute(PostSuggestModel postSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.bzT.mProgress;
        progressBar.setVisibility(8);
        if (postSuggestModel == null || this.ZF == null || !this.ZF.sp().tq().ss()) {
            this.bzT.showToast(this.bzT.getPageContext().getString(com.baidu.tieba.y.neterror));
        } else if (this.ZF.sp().tq().pv()) {
            this.bzT.bzw = postSuggestModel;
            this.bzT.refresh();
        } else {
            this.bzT.showToast(this.ZF.getErrorString());
        }
        this.bzT.bzy = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        ProgressBar progressBar;
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        progressBar = this.bzT.mProgress;
        progressBar.setVisibility(8);
        this.bzT.bzy = null;
        super.onCancelled();
    }
}
