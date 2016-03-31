package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ q dBG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.dBG = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.dBG.aCA();
    }
}
