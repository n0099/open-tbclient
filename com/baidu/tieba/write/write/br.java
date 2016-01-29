package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    private final /* synthetic */ String cXd;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.cXd = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.this$0.aNo.getVisibility() != 0) {
            String str2 = this.cXd;
            str = this.this$0.cWW;
            if (!str2.equals(str)) {
                this.this$0.nN(this.cXd);
                this.this$0.kW(this.cXd);
                this.this$0.cWU = this.val$id;
            }
        }
    }
}
