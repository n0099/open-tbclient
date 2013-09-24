package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2096a;
    private String b;

    public as(WriteActivity writeActivity, String str) {
        this.f2096a = writeActivity;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.p.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.p.c(null, "tieba_resized_image_display");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        ImageView imageView;
        FrameLayout frameLayout;
        this.f2096a.x = null;
        progressBar = this.f2096a.q;
        progressBar.setVisibility(8);
        imageView = this.f2096a.s;
        imageView.setVisibility(8);
        frameLayout = this.f2096a.r;
        frameLayout.setVisibility(8);
        this.f2096a.y();
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
        super.a((as) bitmap);
        this.f2096a.x = null;
        com.baidu.tieba.util.av.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.f2096a.a(bitmap);
    }
}
