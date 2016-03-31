package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements a.b {
    private final /* synthetic */ gn dhA;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity, gn gnVar) {
        this.dht = pbActivity;
        this.dhA = gnVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.dht.HidenSoftKeyPad((InputMethodManager) this.dht.getSystemService("input_method"), this.dhA.getChatMsgView());
        aVar.dismiss();
    }
}
