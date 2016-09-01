package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements a.b {
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ gm eoh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, gm gmVar) {
        this.eob = pbActivity;
        this.eoh = gmVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eob.HidenSoftKeyPad((InputMethodManager) this.eob.getSystemService("input_method"), this.eoh.getChatMsgView());
        aVar.dismiss();
    }
}
