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
        if (this.this$0.bkd.getVisibility() != 0) {
            if ((this.this$0.mBitmap != null || this.this$0.eAt != null) && view.getTag() != null) {
                this.this$0.eAA = false;
                this.this$0.rO(view.getTag().toString());
            }
        }
    }
}
