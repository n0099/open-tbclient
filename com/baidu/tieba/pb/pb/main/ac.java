package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ cx ciO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, cx cxVar) {
        this.ciK = pbActivity;
        this.ciO = cxVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciK.HidenSoftKeyPad((InputMethodManager) this.ciK.getSystemService("input_method"), this.ciO.getChatMsgView());
        aVar.dismiss();
    }
}
