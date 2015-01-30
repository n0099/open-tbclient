package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonImageActivity bIh;
    byte[] mData;
    String mUrl;

    public ba(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.bIh = personImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.mData, this.bIh.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.s.os();
            case -1:
            default:
                return this.bIh.getPageContext().getString(com.baidu.tieba.z.save_error);
            case 0:
                return this.bIh.getPageContext().getString(com.baidu.tieba.z.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute((ba) str);
        this.bIh.showToast(str);
        this.bIh.bIg = null;
        progressBar = this.bIh.mProgress;
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
        this.bIh.bIg = null;
        progressBar = this.bIh.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
