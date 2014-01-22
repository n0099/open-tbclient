package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.a.n;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.a.h;
            if (bitmap == null) {
                bitmap2 = this.a.w;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.a.D = false;
                this.a.a(view.getTag().toString());
            }
        }
    }
}
