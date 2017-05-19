package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    private final /* synthetic */ gz ehH;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity, gz gzVar) {
        this.ehy = pbActivity;
        this.ehH = gzVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ehy.HidenSoftKeyPad((InputMethodManager) this.ehy.getSystemService("input_method"), this.ehH.getChatMsgView());
        aVar.dismiss();
    }
}
