package com.baidu.tieba.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bzj;
    private final /* synthetic */ dc bzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, dc dcVar) {
        this.bzj = pbActivity;
        this.bzm = dcVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bzj.HidenSoftKeyPad((InputMethodManager) this.bzj.getSystemService("input_method"), this.bzm.getChatMsgView());
    }
}
