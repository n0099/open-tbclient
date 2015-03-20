package com.baidu.tieba.pb.chosen;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbChosenActivity bFY;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.j bFZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.j jVar) {
        this.bFY = pbChosenActivity;
        this.bFZ = jVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bFY.HidenSoftKeyPad((InputMethodManager) this.bFY.getSystemService("input_method"), this.bFZ.getChatMsgView());
        aVar.dismiss();
    }
}
