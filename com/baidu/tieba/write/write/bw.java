package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {
    private final /* synthetic */ String eIt;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eIt = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.mProgress.getVisibility() != 0) {
            String str2 = this.eIt;
            str = this.this$0.eIl;
            if (!str2.equals(str)) {
                this.this$0.rA(this.eIt);
                this.this$0.oq(this.eIt);
                this.this$0.eIj = this.val$id;
            }
        }
    }
}
