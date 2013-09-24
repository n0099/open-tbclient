package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EditHeadActivity editHeadActivity) {
        this.f1702a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.f1702a.n;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.f1702a.f;
            if (bitmap == null) {
                bitmap2 = this.f1702a.v;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.f1702a.C = false;
                this.f1702a.c(view.getTag().toString());
            }
        }
    }
}
