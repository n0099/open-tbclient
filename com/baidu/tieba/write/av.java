package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1921a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteImageActivity writeImageActivity, String str, int i) {
        this.f1921a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.f1921a.j;
        if (progressBar.getVisibility() != 0) {
            imageView = this.f1921a.b;
            bitmap = this.f1921a.c;
            imageView.setImageBitmap(bitmap);
            this.f1921a.y = false;
            this.f1921a.e(this.b);
            this.f1921a.u = this.c;
        }
    }
}
