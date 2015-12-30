package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    private final /* synthetic */ String cNJ;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.cNJ = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.mProgress.getVisibility() != 0) {
            this.this$0.aIx.setImageBitmap(this.this$0.mBitmap);
            this.this$0.cNE = false;
            this.this$0.kP(this.cNJ);
            this.this$0.cNA = this.val$id;
        }
    }
}
