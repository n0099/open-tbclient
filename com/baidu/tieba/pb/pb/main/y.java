package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements bc {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bc
    public void c(Object obj) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        Object[] objArr = (Object[]) obj;
        boVar = this.bKT.bKv;
        String valueOf = String.valueOf(boVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.bKT;
        Activity pageActivity = this.bKT.getPageContext().getPageActivity();
        boVar2 = this.bKT.bKv;
        String id = boVar2.getPbData().aar().getId();
        boVar3 = this.bKT.bKv;
        String name = boVar3.getPbData().aar().getName();
        boVar4 = this.bKT.bKv;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, boVar4.getPbData().aas().getId(), valueOf, str, str2)));
    }
}
