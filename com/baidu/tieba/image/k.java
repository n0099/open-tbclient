package com.baidu.tieba.image;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ ImageViewerActivity c;

    public k(ImageViewerActivity imageViewerActivity, String str, byte[] bArr) {
        this.c = imageViewerActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        switch (z.a(this.a, this.b, this.c)) {
            case -2:
                return z.b();
            case -1:
            default:
                return this.c.getString(y.save_error);
            case 0:
                return this.c.getString(y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        TextView textView;
        ProgressBar progressBar;
        super.onPostExecute(str);
        this.c.showToast(str);
        this.c.h = null;
        textView = this.c.i;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        TextView textView;
        ProgressBar progressBar;
        this.c.h = null;
        textView = this.c.i;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
