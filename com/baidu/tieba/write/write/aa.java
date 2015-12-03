package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements a.b {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.dRf.a(0, true, (String) null);
        aVar.dismiss();
    }
}
