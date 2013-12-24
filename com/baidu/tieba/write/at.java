package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.a.g;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.a.c;
            if (bitmap == null) {
                bitmap2 = this.a.p;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.a.x = false;
                this.a.a(view.getTag().toString());
            }
        }
    }
}
