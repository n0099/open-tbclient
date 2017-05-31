package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements a.b {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ hh enm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity, hh hhVar) {
        this.enc = pbActivity;
        this.enm = hhVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.enc.HidenSoftKeyPad((InputMethodManager) this.enc.getSystemService("input_method"), this.enm.getChatMsgView());
        aVar.dismiss();
    }
}
