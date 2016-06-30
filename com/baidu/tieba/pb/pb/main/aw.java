package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements PbActivity.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        Object[] objArr = (Object[]) obj;
        dgVar = this.dPF.dOf;
        String valueOf = String.valueOf(dgVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.dPF;
        Activity pageActivity = this.dPF.getPageContext().getPageActivity();
        dgVar2 = this.dPF.dOf;
        String id = dgVar2.getPbData().aDN().getId();
        dgVar3 = this.dPF.dOf;
        String name = dgVar3.getPbData().aDN().getName();
        dgVar4 = this.dPF.dOf;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, dgVar4.getPbData().aDO().getId(), valueOf, str, str2)));
    }
}
