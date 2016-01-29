package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements PbActivity.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        Object[] objArr = (Object[]) obj;
        cmVar = this.cNq.cMF;
        String valueOf = String.valueOf(cmVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.cNq;
        Activity pageActivity = this.cNq.getPageContext().getPageActivity();
        cmVar2 = this.cNq.cMF;
        String id = cmVar2.getPbData().aoE().getId();
        cmVar3 = this.cNq.cMF;
        String name = cmVar3.getPbData().aoE().getName();
        cmVar4 = this.cNq.cMF;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, cmVar4.getPbData().aoF().getId(), valueOf, str, str2)));
    }
}
