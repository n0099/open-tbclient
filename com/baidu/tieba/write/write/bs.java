package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    private final /* synthetic */ String eCc;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eCc = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.mProgress.getVisibility() != 0) {
            String str2 = this.eCc;
            str = this.this$0.eBU;
            if (!str2.equals(str)) {
                this.this$0.rp(this.eCc);
                this.this$0.oc(this.eCc);
                this.this$0.eBS = this.val$id;
            }
        }
    }
}
