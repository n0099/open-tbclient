package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m bpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bpZ = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        validateActivity = this.bpZ.bpQ;
        validateActivity.finish();
    }
}
