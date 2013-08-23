package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditHeadActivity editHeadActivity) {
        this.f1657a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.f1657a.n;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.f1657a.f;
            if (bitmap == null) {
                bitmap2 = this.f1657a.v;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.f1657a.C = false;
                this.f1657a.c(view.getTag().toString());
            }
        }
    }
}
