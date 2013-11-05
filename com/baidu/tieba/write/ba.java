package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2649a;
    final /* synthetic */ int b;
    final /* synthetic */ WriteImageActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteImageActivity writeImageActivity, String str, int i) {
        this.c = writeImageActivity;
        this.f2649a = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.c.j;
        if (progressBar.getVisibility() != 0) {
            imageView = this.c.b;
            bitmap = this.c.c;
            imageView.setImageBitmap(bitmap);
            this.c.z = false;
            this.c.e(this.f2649a);
            this.c.u = this.b;
        }
    }
}
