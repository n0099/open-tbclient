package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements PbActivity.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void g(Object obj) {
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        if (!com.baidu.adp.lib.util.i.gm()) {
            this.eah.showToast(r.j.network_not_available);
            return;
        }
        Object[] objArr = (Object[]) obj;
        dcVar = this.eah.dYA;
        String valueOf = String.valueOf(dcVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.eah;
        Activity pageActivity = this.eah.getPageContext().getPageActivity();
        dcVar2 = this.eah.dYA;
        String id = dcVar2.getPbData().aIk().getId();
        dcVar3 = this.eah.dYA;
        String name = dcVar3.getPbData().aIk().getName();
        dcVar4 = this.eah.dYA;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, dcVar4.getPbData().aIl().getId(), valueOf, str, str2)));
    }
}
