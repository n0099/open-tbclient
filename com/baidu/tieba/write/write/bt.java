package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    private final /* synthetic */ String eqJ;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eqJ = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.ban.getVisibility() != 0) {
            String str2 = this.eqJ;
            str = this.this$0.eqB;
            if (!str2.equals(str)) {
                this.this$0.rv(this.eqJ);
                this.this$0.oy(this.eqJ);
                this.this$0.eqz = this.val$id;
            }
        }
    }
}
