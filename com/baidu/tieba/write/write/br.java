package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.ban.getVisibility() != 0) {
            if ((this.this$0.mBitmap != null || this.this$0.eqw != null) && view.getTag() != null) {
                this.this$0.eqD = false;
                this.this$0.rv(view.getTag().toString());
            }
        }
    }
}
