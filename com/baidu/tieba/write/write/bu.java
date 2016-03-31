package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    private final /* synthetic */ String drF;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.drF = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.aQj.getVisibility() != 0) {
            this.this$0.aMx.setImageBitmap(this.this$0.mBitmap);
            this.this$0.drA = false;
            this.this$0.mk(this.drF);
            this.this$0.drw = this.val$id;
        }
    }
}
