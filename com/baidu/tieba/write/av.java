package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1890a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteImageActivity writeImageActivity, String str, int i) {
        this.f1890a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.f1890a.j;
        if (progressBar.getVisibility() != 0) {
            imageView = this.f1890a.b;
            bitmap = this.f1890a.c;
            imageView.setImageBitmap(bitmap);
            this.f1890a.y = false;
            this.f1890a.e(this.b);
            this.f1890a.u = this.c;
        }
    }
}
