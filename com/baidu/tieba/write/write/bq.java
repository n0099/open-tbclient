package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    private final /* synthetic */ String cXd;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.cXd = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.aNo.getVisibility() != 0) {
            this.this$0.aJB.setImageBitmap(this.this$0.mBitmap);
            this.this$0.cWY = false;
            this.this$0.kW(this.cXd);
            this.this$0.cWU = this.val$id;
        }
    }
}
