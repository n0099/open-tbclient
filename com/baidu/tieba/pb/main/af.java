package com.baidu.tieba.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;
    private final /* synthetic */ db bAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, db dbVar) {
        this.bAT = pbActivity;
        this.bAW = dbVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bAT.HidenSoftKeyPad((InputMethodManager) this.bAT.getSystemService("input_method"), this.bAW.getChatMsgView());
    }
}
