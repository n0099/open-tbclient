package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements a.b {
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ ef cCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, ef efVar) {
        this.cCm = pbActivity;
        this.cCq = efVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cCm.HidenSoftKeyPad((InputMethodManager) this.cCm.getSystemService("input_method"), this.cCq.getChatMsgView());
        aVar.dismiss();
    }
}
