package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ gm eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, gm gmVar) {
        this.eqa = pbActivity;
        this.eqf = gmVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eqa.HidenSoftKeyPad((InputMethodManager) this.eqa.getSystemService("input_method"), this.eqf.getChatMsgView());
        aVar.dismiss();
    }
}
