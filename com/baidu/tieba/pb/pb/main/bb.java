package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements a.b {
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ ga djJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity, ga gaVar) {
        this.djE = pbActivity;
        this.djJ = gaVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.djE.HidenSoftKeyPad((InputMethodManager) this.djE.getSystemService("input_method"), this.djJ.getChatMsgView());
        aVar.dismiss();
    }
}
