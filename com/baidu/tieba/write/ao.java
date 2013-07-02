package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask {
    final /* synthetic */ WriteActivity a;
    private String b;

    public ao(WriteActivity writeActivity, String str) {
        this.a = writeActivity;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.m.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.m.c(null, "tieba_resized_image_display");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        ImageView imageView;
        FrameLayout frameLayout;
        this.a.u = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        imageView = this.a.p;
        imageView.setVisibility(8);
        frameLayout = this.a.o;
        frameLayout.setVisibility(8);
        this.a.p();
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        super.a((Object) bitmap);
        this.a.u = null;
        com.baidu.tieba.util.z.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.a.a(bitmap);
    }
}
