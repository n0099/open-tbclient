package com.baidu.tieba.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements bg {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bg
    public void c(Object obj) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        Object[] objArr = (Object[]) obj;
        bqVar = this.bAS.bAr;
        String valueOf = String.valueOf(bqVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.bAS;
        Activity pageActivity = this.bAS.getPageContext().getPageActivity();
        bqVar2 = this.bAS.bAr;
        String id = bqVar2.getPbData().aeI().getId();
        bqVar3 = this.bAS.bAr;
        String name = bqVar3.getPbData().aeI().getName();
        bqVar4 = this.bAS.bAr;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, bqVar4.getPbData().ahe().getId(), valueOf, str, str2)));
    }
}
