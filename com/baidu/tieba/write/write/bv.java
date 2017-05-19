package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    private final /* synthetic */ String ezH;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.ezH = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.mProgress.getVisibility() != 0) {
            this.this$0.mImage.setImageBitmap(this.this$0.mBitmap);
            this.this$0.ezB = false;
            this.this$0.ob(this.ezH);
            this.this$0.ezx = this.val$id;
        }
    }
}
