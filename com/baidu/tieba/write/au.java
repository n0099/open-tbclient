package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ WriteImageActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteImageActivity writeImageActivity, String str, int i) {
        this.c = writeImageActivity;
        this.a = str;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.c.g;
        if (progressBar.getVisibility() != 0) {
            imageView = this.c.b;
            bitmap = this.c.c;
            imageView.setImageBitmap(bitmap);
            this.c.x = false;
            this.c.c(this.a);
            this.c.s = this.b;
        }
    }
}
