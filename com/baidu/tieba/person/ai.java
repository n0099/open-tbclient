package com.baidu.tieba.person;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ PersonChangeActivity cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PersonChangeActivity personChangeActivity) {
        this.cqc = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.cqc.aiB();
    }
}
