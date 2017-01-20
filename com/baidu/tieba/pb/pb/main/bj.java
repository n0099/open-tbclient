package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ gs eje;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, gs gsVar) {
        this.eiV = pbActivity;
        this.eje = gsVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eiV.HidenSoftKeyPad((InputMethodManager) this.eiV.getSystemService("input_method"), this.eje.getChatMsgView());
        aVar.dismiss();
    }
}
