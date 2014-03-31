package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn implements com.baidu.tbadk.core.dialog.g {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.g
    public final void a(com.baidu.tbadk.core.dialog.d dVar, int i) {
        if (i == 0) {
            this.a.showBlackListAlertDialog();
        }
        dVar.c();
    }
}
