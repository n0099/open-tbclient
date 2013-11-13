package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2692a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteImageActivity writeImageActivity) {
        this.f2692a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.f2692a.g;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.f2692a.c;
            if (bitmap == null) {
                bitmap2 = this.f2692a.p;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.f2692a.x = false;
                this.f2692a.a(view.getTag().toString());
            }
        }
    }
}
