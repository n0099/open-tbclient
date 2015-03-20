package com.baidu.tieba.setting.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.ccF.ahY();
    }
}
