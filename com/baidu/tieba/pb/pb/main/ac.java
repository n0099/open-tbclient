package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements PbActivity.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        ca caVar;
        ca caVar2;
        ca caVar3;
        ca caVar4;
        Object[] objArr = (Object[]) obj;
        caVar = this.cjN.cjj;
        String valueOf = String.valueOf(caVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.cjN;
        Activity pageActivity = this.cjN.getPageContext().getPageActivity();
        caVar2 = this.cjN.cjj;
        String id = caVar2.getPbData().afg().getId();
        caVar3 = this.cjN.cjj;
        String name = caVar3.getPbData().afg().getName();
        caVar4 = this.cjN.cjj;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, caVar4.getPbData().afh().getId(), valueOf, str, str2)));
    }
}
