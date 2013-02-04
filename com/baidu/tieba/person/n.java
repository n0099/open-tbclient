package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.a.m;
        if (progressBar.getVisibility() == 0) {
            return;
        }
        bitmap = this.a.g;
        if (bitmap == null) {
            bitmap2 = this.a.u;
            if (bitmap2 == null) {
                return;
            }
        }
        if (view.getTag() != null) {
            this.a.B = false;
            this.a.c(view.getTag().toString());
        }
    }
}
