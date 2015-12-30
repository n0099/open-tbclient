package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ ep cFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity, ep epVar) {
        this.cFS = pbActivity;
        this.cFW = epVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cFS.HidenSoftKeyPad((InputMethodManager) this.cFS.getSystemService("input_method"), this.cFW.getChatMsgView());
        aVar.dismiss();
    }
}
