package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.coW.getVisibility() != 0) {
            if ((this.this$0.mBitmap != null || this.this$0.eGB != null) && view.getTag() != null) {
                this.this$0.eGI = false;
                this.this$0.sL(view.getTag().toString());
            }
        }
    }
}
