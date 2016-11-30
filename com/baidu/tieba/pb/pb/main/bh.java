package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements a.b {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ gp evU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, gp gpVar) {
        this.evL = pbActivity;
        this.evU = gpVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.evL.HidenSoftKeyPad((InputMethodManager) this.evL.getSystemService("input_method"), this.evU.getChatMsgView());
        aVar.dismiss();
    }
}
