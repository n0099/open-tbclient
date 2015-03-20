package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
    private com.baidu.tbadk.core.util.aa ZD = null;
    final /* synthetic */ SquareSearchActivity bzG;
    BasicNameValuePair bzJ;
    private String mUrl;

    public aq(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.bzG = squareSearchActivity;
        this.mUrl = null;
        this.bzJ = null;
        this.mUrl = str;
        this.bzJ = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        FrameLayout frameLayout;
        progressBar = this.bzG.mProgress;
        progressBar.setVisibility(0);
        frameLayout = this.bzG.byR;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public ForumSuggestModel doInBackground(Object... objArr) {
        ForumSuggestModel forumSuggestModel = null;
        try {
            this.ZD = new com.baidu.tbadk.core.util.aa(this.mUrl);
            this.ZD.a(this.bzJ);
            String rO = this.ZD.rO();
            if (rO == null) {
                return null;
            }
            forumSuggestModel = ForumSuggestModel.parserJson(rO);
            this.bzG.bzn = this.bzJ.getValue();
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
        progressBar = this.bzG.mProgress;
        progressBar.setVisibility(8);
        if (forumSuggestModel != null) {
            this.bzG.bzi = forumSuggestModel;
            this.bzG.refresh();
        }
        this.bzG.bzk = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        progressBar = this.bzG.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
