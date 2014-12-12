package com.baidu.tieba.image;

import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, String> {
    byte[] mData;
    String mUrl;
    final /* synthetic */ ImageViewerActivity this$0;

    public q(ImageViewerActivity imageViewerActivity, String str, byte[] bArr) {
        this.this$0 = imageViewerActivity;
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
        switch (s.a(this.mUrl, this.mData, this.this$0.getPageContext().getPageActivity())) {
            case -2:
                return s.op();
            case -1:
            default:
                return this.this$0.getPageContext().getString(z.save_error);
            case 0:
                return this.this$0.getPageContext().getString(z.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        View view;
        super.onPostExecute((q) str);
        this.this$0.showToast(str);
        this.this$0.bqn = null;
        view = this.this$0.bqo;
        view.setClickable(true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        View view;
        this.this$0.bqn = null;
        view = this.this$0.bqo;
        view.setClickable(true);
        super.cancel(true);
    }
}
