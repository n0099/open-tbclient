package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonImageActivity bQE;
    byte[] mData;
    String mUrl;

    public ay(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.bQE = personImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.o.a(this.mUrl, this.mData, this.bQE.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.rI();
            case -1:
            default:
                return this.bQE.getPageContext().getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.bQE.getPageContext().getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute((ay) str);
        this.bQE.showToast(str);
        this.bQE.bQD = null;
        progressBar = this.bQE.mProgress;
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.bQE.bQD = null;
        progressBar = this.bQE.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
