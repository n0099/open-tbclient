package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements PbActivity.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        Object[] objArr = (Object[]) obj;
        bkVar = this.cbo.caL;
        String valueOf = String.valueOf(bkVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.cbo;
        Activity pageActivity = this.cbo.getPageContext().getPageActivity();
        bkVar2 = this.cbo.caL;
        String id = bkVar2.getPbData().acG().getId();
        bkVar3 = this.cbo.caL;
        String name = bkVar3.getPbData().acG().getName();
        bkVar4 = this.cbo.caL;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, bkVar4.getPbData().acH().getId(), valueOf, str, str2)));
    }
}
