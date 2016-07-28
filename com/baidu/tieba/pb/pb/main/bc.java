package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements a.b {
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ gl ebY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity, gl glVar) {
        this.ebT = pbActivity;
        this.ebY = glVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.ebT.HidenSoftKeyPad((InputMethodManager) this.ebT.getSystemService("input_method"), this.ebY.getChatMsgView());
        aVar.dismiss();
    }
}
