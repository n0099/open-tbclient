package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ fm cNu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity, fm fmVar) {
        this.cNq = pbActivity;
        this.cNu = fmVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.cNq.HidenSoftKeyPad((InputMethodManager) this.cNq.getSystemService("input_method"), this.cNu.getChatMsgView());
        aVar.dismiss();
    }
}
