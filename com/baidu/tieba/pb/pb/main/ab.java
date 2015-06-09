package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;
    private final /* synthetic */ dc bKV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity, dc dcVar) {
        this.bKU = pbActivity;
        this.bKV = dcVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bKU.HidenSoftKeyPad((InputMethodManager) this.bKU.getSystemService("input_method"), this.bKV.getChatMsgView());
        aVar.dismiss();
    }
}
