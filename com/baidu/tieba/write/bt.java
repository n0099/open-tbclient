package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.this$0.mBitmap;
            if (bitmap == null) {
                bitmap2 = this.this$0.JN;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.this$0.JU = false;
                this.this$0.ck(view.getTag().toString());
            }
        }
    }
}
