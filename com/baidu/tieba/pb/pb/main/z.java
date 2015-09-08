package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements PbActivity.a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        Object[] objArr = (Object[]) obj;
        bkVar = this.ccj.cbG;
        String valueOf = String.valueOf(bkVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.ccj;
        Activity pageActivity = this.ccj.getPageContext().getPageActivity();
        bkVar2 = this.ccj.cbG;
        String id = bkVar2.getPbData().acP().getId();
        bkVar3 = this.ccj.cbG;
        String name = bkVar3.getPbData().acP().getName();
        bkVar4 = this.ccj.cbG;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, bkVar4.getPbData().acQ().getId(), valueOf, str, str2)));
    }
}
