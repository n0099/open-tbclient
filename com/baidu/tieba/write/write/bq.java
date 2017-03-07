package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.bqO.getVisibility() != 0) {
            if ((this.this$0.mBitmap != null || this.this$0.eDS != null) && view.getTag() != null) {
                this.this$0.eDZ = false;
                this.this$0.qW(view.getTag().toString());
            }
        }
    }
}
