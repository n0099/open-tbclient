package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final /* synthetic */ String edt;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.edt = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.this$0.cbl.getVisibility() != 0) {
            this.this$0.ecT.f(this.this$0.mBitmap);
            this.this$0.edn = false;
            this.this$0.nT(this.edt);
            this.this$0.edj = this.val$id;
        }
    }
}
