package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements a.b {
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ dp cjR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, dp dpVar) {
        this.cjN = pbActivity;
        this.cjR = dpVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cjN.HidenSoftKeyPad((InputMethodManager) this.cjN.getSystemService("input_method"), this.cjR.getChatMsgView());
        aVar.dismiss();
    }
}
