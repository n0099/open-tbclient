package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonImageActivity bCW;
    byte[] dL;
    String mUrl;

    public bj(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.bCW = personImageActivity;
        this.mUrl = null;
        this.dL = null;
        this.mUrl = str;
        this.dL = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.s.a(this.mUrl, this.dL, this.bCW)) {
            case -2:
                return com.baidu.tbadk.core.util.s.lu();
            case -1:
            default:
                return this.bCW.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.bCW.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((bj) str);
        this.bCW.showToast(str);
        this.bCW.bCV = null;
        this.bCW.hideProgressBar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bCW.bCV = null;
        this.bCW.hideProgressBar();
        super.cancel(true);
    }
}
