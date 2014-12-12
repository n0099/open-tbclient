package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonImageActivity bGv;
    byte[] mData;
    String mUrl;

    public bb(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.bGv = personImageActivity;
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
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.mData, this.bGv.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.s.op();
            case -1:
            default:
                return this.bGv.getPageContext().getString(com.baidu.tieba.z.save_error);
            case 0:
                return this.bGv.getPageContext().getString(com.baidu.tieba.z.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute((bb) str);
        this.bGv.showToast(str);
        this.bGv.bGu = null;
        progressBar = this.bGv.mProgress;
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
        this.bGv.bGu = null;
        progressBar = this.bGv.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
