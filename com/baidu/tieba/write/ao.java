package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends AsyncTask {
    final /* synthetic */ WriteActivity a;
    private String b;

    public ao(WriteActivity writeActivity, String str) {
        this.a = writeActivity;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.c.o.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.c.o.c(null, "tieba_resized_image_display");
    }

    public void a() {
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
        this.a.o();
        super.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        this.a.u = null;
        com.baidu.tieba.c.ag.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        this.a.a(bitmap);
    }
}
