package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<Object, Integer, BarSuggestModel> {
    private com.baidu.tbadk.core.util.ad CX = null;
    final /* synthetic */ SquareSearchActivity btb;
    BasicNameValuePair bte;
    private String mUrl;

    public ak(SquareSearchActivity squareSearchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.btb = squareSearchActivity;
        this.mUrl = null;
        this.bte = null;
        this.mUrl = str;
        this.bte = basicNameValuePair;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        com.baidu.tbadk.core.view.x xVar;
        FrameLayout frameLayout;
        progressBar = this.btb.mProgress;
        progressBar.setVisibility(0);
        xVar = this.btb.mNoDataView;
        xVar.setVisibility(8);
        frameLayout = this.btb.bsC;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public BarSuggestModel doInBackground(Object... objArr) {
        BarSuggestModel barSuggestModel = null;
        try {
            this.CX = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CX.a(this.bte);
            String oy = this.CX.oy();
            if (oy == null) {
                return null;
            }
            barSuggestModel = BarSuggestModel.parserJson(oy);
            this.btb.bsP = this.bte.getValue();
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
        progressBar = this.btb.mProgress;
        progressBar.setVisibility(8);
        if (barSuggestModel != null) {
            this.btb.bsK = barSuggestModel;
            this.btb.refresh();
        }
        this.btb.bsM = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.CX != null) {
            this.CX.dJ();
            this.CX = null;
        }
        progressBar = this.btb.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
