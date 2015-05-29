package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, Integer, ForumSuggestModel> {
    private com.baidu.tbadk.core.util.aa aaG = null;
    final /* synthetic */ SquareSearchActivity bCE;
    private BasicNameValuePair bCK;
    private String mUrl;

    public ao(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.bCE = squareSearchActivity;
        this.mUrl = null;
        this.bCK = null;
        this.mUrl = str;
        this.bCK = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        com.baidu.tbadk.core.view.x xVar;
        SquareSearchActivity squareSearchActivity = this.bCE;
        frameLayout = this.bCE.bBK;
        squareSearchActivity.showLoadingView(frameLayout, true, this.bCE.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds320));
        frameLayout2 = this.bCE.bBL;
        frameLayout2.setVisibility(8);
        xVar = this.bCE.mNoDataView;
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
            this.aaG.a(this.bCK);
            String sw = this.aaG.sw();
            if (sw == null) {
                return null;
            }
            forumSuggestModel = ForumSuggestModel.parserJson(sw);
            this.bCE.bCg = this.bCK.getValue();
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
        SquareSearchActivity squareSearchActivity = this.bCE;
        frameLayout = this.bCE.bBK;
        squareSearchActivity.hideLoadingView(frameLayout);
        if (forumSuggestModel != null) {
            this.bCE.bCb = forumSuggestModel;
            this.bCE.refresh();
        }
        this.bCE.bCd = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        FrameLayout frameLayout;
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        SquareSearchActivity squareSearchActivity = this.bCE;
        frameLayout = this.bCE.bBK;
        squareSearchActivity.hideLoadingView(frameLayout);
        super.cancel(true);
    }
}
