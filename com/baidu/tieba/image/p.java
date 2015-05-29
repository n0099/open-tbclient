package com.baidu.tieba.image;

import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, String> {
    byte[] mData;
    String mUrl;
    final /* synthetic */ ImageViewerActivity this$0;

    public p(ImageViewerActivity imageViewerActivity, String str, byte[] bArr) {
        this.this$0 = imageViewerActivity;
        this.mUrl = null;
        this.mData = null;
        this.mUrl = str;
        this.mData = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.o.a(this.mUrl, this.mData, this.this$0.getPageContext().getPageActivity())) {
            case -2:
                return com.baidu.tbadk.core.util.o.sr();
            case -1:
            default:
                return this.this$0.getPageContext().getString(t.save_error);
            case 0:
                return this.this$0.getPageContext().getString(t.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        View view;
        super.onPostExecute((p) str);
        this.this$0.showToast(str);
        this.this$0.bxu = null;
        view = this.this$0.bxv;
        view.setClickable(true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        View view;
        this.this$0.bxu = null;
        view = this.this$0.bxv;
        view.setClickable(true);
        super.cancel(true);
    }
}
