package com.baidu.tieba.pb.main;

import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;
    private final /* synthetic */ cy bvj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, cy cyVar) {
        this.bvg = pbActivity;
        this.bvj = cyVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bvg.HidenSoftKeyPad((InputMethodManager) this.bvg.getSystemService("input_method"), this.bvj.getChatMsgView());
    }
}
