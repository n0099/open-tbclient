package com.baidu.tieba.write.vcode.oldVcode;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ VcodeActivity fXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VcodeActivity vcodeActivity) {
        this.fXh = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fXh.ro(null);
    }
}
