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
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void g(Object obj) {
        dj djVar;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        if (!com.baidu.adp.lib.util.i.gm()) {
            this.evL.showToast(r.j.network_not_available);
            return;
        }
        Object[] objArr = (Object[]) obj;
        djVar = this.evL.euf;
        String valueOf = String.valueOf(djVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.evL;
        Activity pageActivity = this.evL.getPageContext().getPageActivity();
        djVar2 = this.evL.euf;
        String id = djVar2.getPbData().aOk().getId();
        djVar3 = this.evL.euf;
        String name = djVar3.getPbData().aOk().getName();
        djVar4 = this.evL.euf;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, djVar4.getPbData().aOl().getId(), valueOf, str, str2)));
    }
}
