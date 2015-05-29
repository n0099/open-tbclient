package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;
    private final /* synthetic */ dc bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, dc dcVar) {
        this.bKT = pbActivity;
        this.bKU = dcVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bKT.HidenSoftKeyPad((InputMethodManager) this.bKT.getSystemService("input_method"), this.bKU.getChatMsgView());
        aVar.dismiss();
    }
}
