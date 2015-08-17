package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ cw cbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, cw cwVar) {
        this.cbo = pbActivity;
        this.cbs = cwVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cbo.HidenSoftKeyPad((InputMethodManager) this.cbo.getSystemService("input_method"), this.cbs.getChatMsgView());
        aVar.dismiss();
    }
}
