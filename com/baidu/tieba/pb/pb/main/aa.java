package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements bf {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.bf
    public void c(Object obj) {
        br brVar;
        br brVar2;
        br brVar3;
        br brVar4;
        Object[] objArr = (Object[]) obj;
        brVar = this.bIJ.bIg;
        String valueOf = String.valueOf(brVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.bIJ;
        Activity pageActivity = this.bIJ.getPageContext().getPageActivity();
        brVar2 = this.bIJ.bIg;
        String id = brVar2.getPbData().Za().getId();
        brVar3 = this.bIJ.bIg;
        String name = brVar3.getPbData().Za().getName();
        brVar4 = this.bIJ.bIg;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, brVar4.getPbData().Zb().getId(), valueOf, str, str2)));
    }
}
