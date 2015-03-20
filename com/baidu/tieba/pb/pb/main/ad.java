package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;
    private final /* synthetic */ di bIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, di diVar) {
        this.bIv = pbActivity;
        this.bIw = diVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bIv.HidenSoftKeyPad((InputMethodManager) this.bIv.getSystemService("input_method"), this.bIw.getChatMsgView());
        aVar.dismiss();
    }
}
