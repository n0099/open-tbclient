package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;
    private final /* synthetic */ dj bIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, dj djVar) {
        this.bIJ = pbActivity;
        this.bIK = djVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bIJ.HidenSoftKeyPad((InputMethodManager) this.bIJ.getSystemService("input_method"), this.bIK.getChatMsgView());
        aVar.dismiss();
    }
}
