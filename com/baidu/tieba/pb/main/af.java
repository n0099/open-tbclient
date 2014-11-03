package com.baidu.tieba.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvu;
    private final /* synthetic */ cy bvx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, cy cyVar) {
        this.bvu = pbActivity;
        this.bvx = cyVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bvu.HidenSoftKeyPad((InputMethodManager) this.bvu.getSystemService("input_method"), this.bvx.getChatMsgView());
    }
}
