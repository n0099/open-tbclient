package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.b {
    private final /* synthetic */ cx ciD;
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, cx cxVar) {
        this.ciz = pbActivity;
        this.ciD = cxVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciz.HidenSoftKeyPad((InputMethodManager) this.ciz.getSystemService("input_method"), this.ciD.getChatMsgView());
        aVar.dismiss();
    }
}
