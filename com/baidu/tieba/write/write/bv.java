package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    private final /* synthetic */ String eNn;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eNn = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.cub.getVisibility() != 0) {
            String str2 = this.eNn;
            str = this.this$0.eNf;
            if (!str2.equals(str)) {
                this.this$0.ti(this.eNn);
                this.this$0.pW(this.eNn);
                this.this$0.eNd = this.val$id;
            }
        }
    }
}
