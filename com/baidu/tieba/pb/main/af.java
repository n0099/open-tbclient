package com.baidu.tieba.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;
    private final /* synthetic */ db bAV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, db dbVar) {
        this.bAS = pbActivity;
        this.bAV = dbVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bAS.HidenSoftKeyPad((InputMethodManager) this.bAS.getSystemService("input_method"), this.bAV.getChatMsgView());
    }
}
