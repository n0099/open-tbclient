package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonChangeActivity bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.bSN.aeu();
    }
}
