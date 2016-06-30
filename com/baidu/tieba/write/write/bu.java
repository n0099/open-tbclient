package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    private final /* synthetic */ String edt;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.edt = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.cbl.getVisibility() != 0) {
            String str2 = this.edt;
            str = this.this$0.edl;
            if (!str2.equals(str)) {
                this.this$0.rc(this.edt);
                this.this$0.nT(this.edt);
                this.this$0.edj = this.val$id;
            }
        }
    }
}
