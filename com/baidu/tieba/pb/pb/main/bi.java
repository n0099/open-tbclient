package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ gs elX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, gs gsVar) {
        this.elO = pbActivity;
        this.elX = gsVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.elO.HidenSoftKeyPad((InputMethodManager) this.elO.getSystemService("input_method"), this.elX.getChatMsgView());
        aVar.dismiss();
    }
}
