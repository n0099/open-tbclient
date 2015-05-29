package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteImageActivity writeImageActivity) {
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
                bitmap2 = this.this$0.bRk;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.this$0.bRr = false;
                this.this$0.iA(view.getTag().toString());
            }
        }
    }
}
