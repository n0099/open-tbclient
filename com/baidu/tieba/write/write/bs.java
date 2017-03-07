package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    private final /* synthetic */ String eEf;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eEf = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.bqO.getVisibility() != 0) {
            String str2 = this.eEf;
            str = this.this$0.eDX;
            if (!str2.equals(str)) {
                this.this$0.qW(this.eEf);
                this.this$0.nY(this.eEf);
                this.this$0.eDV = this.val$id;
            }
        }
    }
}
