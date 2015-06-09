package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
    private com.baidu.tbadk.core.util.aa aaG = null;
    final /* synthetic */ SquareSearchActivity bCF;
    private BasicNameValuePair bCL;
    private String mUrl;

    public ao(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.bCF = squareSearchActivity;
        this.mUrl = null;
        this.bCL = null;
        this.mUrl = str;
        this.bCL = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        com.baidu.tbadk.core.view.x xVar;
        SquareSearchActivity squareSearchActivity = this.bCF;
        frameLayout = this.bCF.bBL;
        squareSearchActivity.showLoadingView(frameLayout, true, this.bCF.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds320));
        frameLayout2 = this.bCF.bBM;
        frameLayout2.setVisibility(8);
        xVar = this.bCF.mNoDataView;
        xVar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: A */
    public ForumSuggestModel doInBackground(Object... objArr) {
        ForumSuggestModel forumSuggestModel = null;
        try {
            this.aaG = new com.baidu.tbadk.core.util.aa(this.mUrl);
            this.aaG.a(this.bCL);
            String sw = this.aaG.sw();
            if (sw == null) {
                return null;
            }
            forumSuggestModel = ForumSuggestModel.parserJson(sw);
            this.bCF.bCh = this.bCL.getValue();
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
        FrameLayout frameLayout;
        SquareSearchActivity squareSearchActivity = this.bCF;
        frameLayout = this.bCF.bBL;
        squareSearchActivity.hideLoadingView(frameLayout);
        if (forumSuggestModel != null) {
            this.bCF.bCc = forumSuggestModel;
            this.bCF.refresh();
        }
        this.bCF.bCe = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        FrameLayout frameLayout;
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        SquareSearchActivity squareSearchActivity = this.bCF;
        frameLayout = this.bCF.bBL;
        squareSearchActivity.hideLoadingView(frameLayout);
        super.cancel(true);
    }
}
