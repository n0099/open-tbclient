package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, String> {
    byte[] dL;
    String mUrl;
    final /* synthetic */ ImageViewerActivity this$0;

    public m(ImageViewerActivity imageViewerActivity, String str, byte[] bArr) {
        this.this$0 = imageViewerActivity;
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
        switch (s.a(this.mUrl, this.dL, this.this$0)) {
            case -2:
                return s.lu();
            case -1:
            default:
                return this.this$0.getString(y.save_error);
            case 0:
                return this.this$0.getString(y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((m) str);
        this.this$0.showToast(str);
        this.this$0.bkN = null;
        this.this$0.hideProgressBar();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.this$0.bkN = null;
        this.this$0.hideProgressBar();
        super.cancel(true);
    }
}
