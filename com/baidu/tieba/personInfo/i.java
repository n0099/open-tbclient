package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ PersonInfoActivity clO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonInfoActivity personInfoActivity) {
        this.clO = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
