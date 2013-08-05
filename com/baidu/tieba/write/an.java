package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1884a;
    private String b;

    public an(WriteActivity writeActivity, String str) {
        this.f1884a = writeActivity;
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
        this.f1884a.u = null;
        progressBar = this.f1884a.n;
        progressBar.setVisibility(8);
        imageView = this.f1884a.p;
        imageView.setVisibility(8);
        frameLayout = this.f1884a.o;
        frameLayout.setVisibility(8);
        this.f1884a.n();
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
        this.f1884a.u = null;
        com.baidu.tieba.util.aj.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.f1884a.a(bitmap);
    }
}
