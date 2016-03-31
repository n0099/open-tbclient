package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    private final /* synthetic */ String drF;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.drF = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.aQj.getVisibility() != 0) {
            String str2 = this.drF;
            str = this.this$0.dry;
            if (!str2.equals(str)) {
                this.this$0.pc(this.drF);
                this.this$0.mk(this.drF);
                this.this$0.drw = this.val$id;
            }
        }
    }
}
