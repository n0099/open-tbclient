package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.gpp.b(0, true, null);
        aVar.dismiss();
    }
}
