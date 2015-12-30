package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements PbActivity.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        cf cfVar4;
        Object[] objArr = (Object[]) obj;
        cfVar = this.cFS.cFl;
        String valueOf = String.valueOf(cfVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.cFS;
        Activity pageActivity = this.cFS.getPageContext().getPageActivity();
        cfVar2 = this.cFS.cFl;
        String id = cfVar2.getPbData().akG().getId();
        cfVar3 = this.cFS.cFl;
        String name = cfVar3.getPbData().akG().getName();
        cfVar4 = this.cFS.cFl;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, cfVar4.getPbData().akH().getId(), valueOf, str, str2)));
    }
}
