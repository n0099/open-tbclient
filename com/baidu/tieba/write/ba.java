package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2105a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteImageActivity writeImageActivity, String str, int i) {
        this.f2105a = writeImageActivity;
        this.b = str;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.f2105a.j;
        if (progressBar.getVisibility() != 0) {
            imageView = this.f2105a.b;
            bitmap = this.f2105a.c;
            imageView.setImageBitmap(bitmap);
            this.f2105a.y = false;
            this.f2105a.e(this.b);
            this.f2105a.u = this.c;
        }
    }
}
