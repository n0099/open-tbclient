package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ gq emt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, gq gqVar) {
        this.emk = pbActivity;
        this.emt = gqVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.emk.HidenSoftKeyPad((InputMethodManager) this.emk.getSystemService("input_method"), this.emt.getChatMsgView());
        aVar.dismiss();
    }
}
