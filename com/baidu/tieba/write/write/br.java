package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    private final /* synthetic */ String eCc;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eCc = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.mProgress.getVisibility() != 0) {
            this.this$0.mImage.setImageBitmap(this.this$0.mBitmap);
            this.this$0.eBW = false;
            this.this$0.oc(this.eCc);
            this.this$0.eBS = this.val$id;
        }
    }
}
