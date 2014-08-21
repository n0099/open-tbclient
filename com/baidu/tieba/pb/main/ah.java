package com.baidu.tieba.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity a;
    private final /* synthetic */ cw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, cw cwVar) {
        this.a = pbActivity;
        this.b = cwVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.d();
        this.a.HidenSoftKeyPad((InputMethodManager) this.a.getSystemService("input_method"), this.b.getChatMsgView());
    }
}
