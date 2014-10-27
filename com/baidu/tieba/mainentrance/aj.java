package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.BarSuggestModel;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    final /* synthetic */ SquareSearchActivity bmO;
    BasicNameValuePair bmR;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;

    public aj(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.bmO = squareSearchActivity;
        this.mUrl = null;
        this.bmR = null;
        this.mUrl = str;
        this.bmR = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        com.baidu.tbadk.core.view.o oVar;
        FrameLayout frameLayout;
        progressBar = this.bmO.mProgress;
        progressBar.setVisibility(0);
        oVar = this.bmO.ahO;
        oVar.setVisibility(8);
        frameLayout = this.bmO.bmn;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public BarSuggestModel doInBackground(Object... objArr) {
        BarSuggestModel barSuggestModel = null;
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
            this.yV.a(this.bmR);
            String lA = this.yV.lA();
            if (lA == null) {
                return null;
            }
            barSuggestModel = BarSuggestModel.parserJson(lA);
            this.bmO.bmB = this.bmR.getValue();
            return barSuggestModel;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return barSuggestModel;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(BarSuggestModel barSuggestModel) {
        ProgressBar progressBar;
        progressBar = this.bmO.mProgress;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.bmO.bmw = barSuggestModel;
            this.bmO.refresh();
        }
        this.bmO.bmy = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        progressBar = this.bmO.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
