package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    private com.baidu.tbadk.core.util.ad CV = null;
    final /* synthetic */ SquareSearchActivity brF;
    BasicNameValuePair brI;
    private String mUrl;

    public ak(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.brF = squareSearchActivity;
        this.mUrl = null;
        this.brI = null;
        this.mUrl = str;
        this.brI = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        com.baidu.tbadk.core.view.x xVar;
        FrameLayout frameLayout;
        progressBar = this.brF.mProgress;
        progressBar.setVisibility(0);
        xVar = this.brF.mNoDataView;
        xVar.setVisibility(8);
        frameLayout = this.brF.bre;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public BarSuggestModel doInBackground(Object... objArr) {
        BarSuggestModel barSuggestModel = null;
        try {
            this.CV = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CV.a(this.brI);
            String ov = this.CV.ov();
            if (ov == null) {
                return null;
            }
            barSuggestModel = BarSuggestModel.parserJson(ov);
            this.brF.brs = this.brI.getValue();
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
        progressBar = this.brF.mProgress;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.brF.brn = barSuggestModel;
            this.brF.refresh();
        }
        this.brF.brp = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.CV != null) {
            this.CV.dL();
            this.CV = null;
        }
        progressBar = this.brF.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
