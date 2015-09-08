package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ cw ccn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, cw cwVar) {
        this.ccj = pbActivity;
        this.ccn = cwVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ccj.HidenSoftKeyPad((InputMethodManager) this.ccj.getSystemService("input_method"), this.ccn.getChatMsgView());
        aVar.dismiss();
    }
}
