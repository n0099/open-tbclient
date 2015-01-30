package com.baidu.tieba.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements bg {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bg
    public void c(Object obj) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        Object[] objArr = (Object[]) obj;
        bqVar = this.bAT.bAs;
        String valueOf = String.valueOf(bqVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.bAT;
        Activity pageActivity = this.bAT.getPageContext().getPageActivity();
        bqVar2 = this.bAT.bAs;
        String id = bqVar2.getPbData().aeN().getId();
        bqVar3 = this.bAT.bAs;
        String name = bqVar3.getPbData().aeN().getName();
        bqVar4 = this.bAT.bAs;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, bqVar4.getPbData().ahj().getId(), valueOf, str, str2)));
    }
}
