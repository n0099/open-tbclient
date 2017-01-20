package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    private final /* synthetic */ String eAG;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.eAG = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.bkd.getVisibility() != 0) {
            String str2 = this.eAG;
            str = this.this$0.eAy;
            if (!str2.equals(str)) {
                this.this$0.rO(this.eAG);
                this.this$0.oQ(this.eAG);
                this.this$0.eAw = this.val$id;
            }
        }
    }
}
