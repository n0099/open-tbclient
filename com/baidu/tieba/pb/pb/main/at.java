package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements PbActivity.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        cw cwVar4;
        Object[] objArr = (Object[]) obj;
        cwVar = this.djE.dih;
        String valueOf = String.valueOf(cwVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.djE;
        Activity pageActivity = this.djE.getPageContext().getPageActivity();
        cwVar2 = this.djE.dih;
        String id = cwVar2.getPbData().avD().getId();
        cwVar3 = this.djE.dih;
        String name = cwVar3.getPbData().avD().getName();
        cwVar4 = this.djE.dih;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, cwVar4.getPbData().avE().getId(), valueOf, str, str2)));
    }
}
