package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ PersonInfoActivity csx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PersonInfoActivity personInfoActivity) {
        this.csx = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
