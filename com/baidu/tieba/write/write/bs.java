package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    private final /* synthetic */ String eqJ;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eqJ = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.ban.getVisibility() != 0) {
            this.this$0.aUt.setImageBitmap(this.this$0.mBitmap);
            this.this$0.eqD = false;
            this.this$0.oy(this.eqJ);
            this.this$0.eqz = this.val$id;
        }
    }
}
