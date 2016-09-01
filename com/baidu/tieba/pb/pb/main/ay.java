package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements PbActivity.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void g(Object obj) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        Object[] objArr = (Object[]) obj;
        dhVar = this.eob.emx;
        String valueOf = String.valueOf(dhVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.eob;
        Activity pageActivity = this.eob.getPageContext().getPageActivity();
        dhVar2 = this.eob.emx;
        String id = dhVar2.getPbData().aLP().getId();
        dhVar3 = this.eob.emx;
        String name = dhVar3.getPbData().aLP().getName();
        dhVar4 = this.eob.emx;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, dhVar4.getPbData().aLQ().getId(), valueOf, str, str2)));
    }
}
