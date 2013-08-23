package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteImageActivity writeImageActivity) {
        this.f1920a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.f1920a.j;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.f1920a.c;
            if (bitmap == null) {
                bitmap2 = this.f1920a.r;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.f1920a.y = false;
                this.f1920a.c(view.getTag().toString());
            }
        }
    }
}
