package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements a.b {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ ht ewr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity, ht htVar) {
        this.ewh = pbActivity;
        this.ewr = htVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ewh.HidenSoftKeyPad((InputMethodManager) this.ewh.getSystemService("input_method"), this.ewr.getChatMsgView());
        aVar.dismiss();
    }
}
