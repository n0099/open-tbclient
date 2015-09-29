package com.baidu.tieba.person.post;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.b {
    final /* synthetic */ p crK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.crK = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.crK.aiZ();
    }
}
