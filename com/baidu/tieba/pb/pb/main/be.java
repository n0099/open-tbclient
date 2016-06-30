package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements a.b {
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ gh dPK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, gh ghVar) {
        this.dPF = pbActivity;
        this.dPK = ghVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.dPF.HidenSoftKeyPad((InputMethodManager) this.dPF.getSystemService("input_method"), this.dPK.getChatMsgView());
        aVar.dismiss();
    }
}
