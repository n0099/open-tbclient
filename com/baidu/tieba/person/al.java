package com.baidu.tieba.person;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    final /* synthetic */ PersonChangeActivity eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity) {
        this.eeV = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.eeV.aKG();
    }
}
