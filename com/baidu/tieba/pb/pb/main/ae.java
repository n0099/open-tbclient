package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements PbActivity.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        cc ccVar4;
        Object[] objArr = (Object[]) obj;
        ccVar = this.cCm.cBG;
        String valueOf = String.valueOf(ccVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.cCm;
        Activity pageActivity = this.cCm.getPageContext().getPageActivity();
        ccVar2 = this.cCm.cBG;
        String id = ccVar2.getPbData().ajy().getId();
        ccVar3 = this.cCm.cBG;
        String name = ccVar3.getPbData().ajy().getName();
        ccVar4 = this.cCm.cBG;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, ccVar4.getPbData().ajz().getId(), valueOf, str, str2)));
    }
}
