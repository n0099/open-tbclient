package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements be {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.be
    public void c(Object obj) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        Object[] objArr = (Object[]) obj;
        bqVar = this.bIv.bHT;
        String valueOf = String.valueOf(bqVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.bIv;
        Activity pageActivity = this.bIv.getPageContext().getPageActivity();
        bqVar2 = this.bIv.bHT;
        String id = bqVar2.getPbData().YO().getId();
        bqVar3 = this.bIv.bHT;
        String name = bqVar3.getPbData().YO().getName();
        bqVar4 = this.bIv.bHT;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, bqVar4.getPbData().YP().getId(), valueOf, str, str2)));
    }
}
