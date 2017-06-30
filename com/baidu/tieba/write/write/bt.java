package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    private final /* synthetic */ String eSh;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eSh = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.mProgress.getVisibility() != 0) {
            this.this$0.mImage.setImageBitmap(this.this$0.mBitmap);
            this.this$0.eSb = false;
            this.this$0.pl(this.eSh);
            this.this$0.eRX = this.val$id;
        }
    }
}
