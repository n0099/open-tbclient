package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements bc {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bc
    public void c(Object obj) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        Object[] objArr = (Object[]) obj;
        boVar = this.bKU.bKw;
        String valueOf = String.valueOf(boVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.bKU;
        Activity pageActivity = this.bKU.getPageContext().getPageActivity();
        boVar2 = this.bKU.bKw;
        String id = boVar2.getPbData().aas().getId();
        boVar3 = this.bKU.bKw;
        String name = boVar3.getPbData().aas().getName();
        boVar4 = this.bKU.bKw;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, boVar4.getPbData().aat().getId(), valueOf, str, str2)));
    }
}
