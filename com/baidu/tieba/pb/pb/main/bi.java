package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ gq ekd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, gq gqVar) {
        this.ejU = pbActivity;
        this.ekd = gqVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ejU.HidenSoftKeyPad((InputMethodManager) this.ejU.getSystemService("input_method"), this.ekd.getChatMsgView());
        aVar.dismiss();
    }
}
