package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
    private com.baidu.tbadk.core.util.aa ZF = null;
    final /* synthetic */ SquareSearchActivity bzT;
    BasicNameValuePair bzW;
    private String mUrl;

    public ap(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.bzT = squareSearchActivity;
        this.mUrl = null;
        this.bzW = null;
        this.mUrl = str;
        this.bzW = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        FrameLayout frameLayout;
        progressBar = this.bzT.mProgress;
        progressBar.setVisibility(0);
        frameLayout = this.bzT.bzd;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public ForumSuggestModel doInBackground(Object... objArr) {
        ForumSuggestModel forumSuggestModel = null;
        try {
            this.ZF = new com.baidu.tbadk.core.util.aa(this.mUrl);
            this.ZF.a(this.bzW);
            String rO = this.ZF.rO();
            if (rO == null) {
                return null;
            }
            forumSuggestModel = ForumSuggestModel.parserJson(rO);
            this.bzT.bzA = this.bzW.getValue();
            return forumSuggestModel;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return forumSuggestModel;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumSuggestModel forumSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.bzT.mProgress;
        progressBar.setVisibility(8);
        if (forumSuggestModel != null) {
            this.bzT.bzv = forumSuggestModel;
            this.bzT.refresh();
        }
        this.bzT.bzx = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        progressBar = this.bzT.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
