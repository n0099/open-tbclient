package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonImageActivity bTk;
    byte[] mData;
    String mUrl;

    public br(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.bTk = personImageActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.o.a(this.mUrl, this.mData, this.bTk.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.sr();
            case -1:
            default:
                return this.bTk.getPageContext().getString(com.baidu.tieba.t.save_error);
            case 0:
                return this.bTk.getPageContext().getString(com.baidu.tieba.t.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute((br) str);
        this.bTk.showToast(str);
        this.bTk.bTj = null;
        progressBar = this.bTk.mProgress;
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
        this.bTk.bTj = null;
        progressBar = this.bTk.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
