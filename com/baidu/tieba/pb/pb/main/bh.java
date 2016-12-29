package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements a.b {
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ gi eaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, gi giVar) {
        this.eah = pbActivity;
        this.eaq = giVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eah.HidenSoftKeyPad((InputMethodManager) this.eah.getSystemService("input_method"), this.eaq.getChatMsgView());
        aVar.dismiss();
    }
}
