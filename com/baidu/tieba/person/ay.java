package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonImageActivity bQo;
    byte[] mData;
    String mUrl;

    public ay(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.bQo = personImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.o.a(this.mUrl, this.mData, this.bQo.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.rI();
            case -1:
            default:
                return this.bQo.getPageContext().getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.bQo.getPageContext().getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute((ay) str);
        this.bQo.showToast(str);
        this.bQo.bQn = null;
        progressBar = this.bQo.mProgress;
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
        this.bQo.bQn = null;
        progressBar = this.bQo.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
