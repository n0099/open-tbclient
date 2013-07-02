package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteImageActivity writeImageActivity, String str, int i) {
        this.a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.a.j;
        if (progressBar.getVisibility() != 0) {
            imageView = this.a.b;
            bitmap = this.a.c;
            imageView.setImageBitmap(bitmap);
            this.a.y = false;
            this.a.e(this.b);
            this.a.u = this.c;
        }
    }
}
