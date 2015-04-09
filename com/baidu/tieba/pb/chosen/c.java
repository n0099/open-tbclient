package com.baidu.tieba.pb.chosen;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbChosenActivity bGl;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.j bGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.j jVar) {
        this.bGl = pbChosenActivity;
        this.bGm = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bGl.HidenSoftKeyPad((InputMethodManager) this.bGl.getSystemService("input_method"), this.bGm.getChatMsgView());
        aVar.dismiss();
    }
}
