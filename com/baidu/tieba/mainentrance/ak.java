package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    private com.baidu.tbadk.core.util.ad CU = null;
    final /* synthetic */ SquareSearchActivity bta;
    BasicNameValuePair btd;
    private String mUrl;

    public ak(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.bta = squareSearchActivity;
        this.mUrl = null;
        this.btd = null;
        this.mUrl = str;
        this.btd = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        com.baidu.tbadk.core.view.x xVar;
        FrameLayout frameLayout;
        progressBar = this.bta.mProgress;
        progressBar.setVisibility(0);
        xVar = this.bta.mNoDataView;
        xVar.setVisibility(8);
        frameLayout = this.bta.bsB;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public BarSuggestModel doInBackground(Object... objArr) {
        BarSuggestModel barSuggestModel = null;
        try {
            this.CU = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CU.a(this.btd);
            String or = this.CU.or();
            if (or == null) {
                return null;
            }
            barSuggestModel = BarSuggestModel.parserJson(or);
            this.bta.bsO = this.btd.getValue();
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
        progressBar = this.bta.mProgress;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.bta.bsJ = barSuggestModel;
            this.bta.refresh();
        }
        this.bta.bsL = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.CU != null) {
            this.CU.dJ();
            this.CU = null;
        }
        progressBar = this.bta.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
