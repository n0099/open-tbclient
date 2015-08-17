package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        akVar = this.cfY.cfP;
        if (akVar.afo() != null) {
            akVar5 = this.cfY.cfP;
            if (akVar5.afo().acX() != null) {
                akVar6 = this.cfY.cfP;
                if (akVar6.afo().acX().getAuthor() != null) {
                    akVar7 = this.cfY.cfP;
                    str = String.valueOf(akVar7.afo().acX().getAuthor().getUserId());
                }
            }
        }
        String str2 = "";
        if (objArr.length > 1) {
            str2 = String.valueOf(objArr[1]);
        }
        String str3 = "";
        if (objArr.length > 2) {
            str3 = String.valueOf(objArr[2]);
        }
        NewSubPbActivity newSubPbActivity = this.cfY;
        Activity pageActivity = this.cfY.getPageContext().getPageActivity();
        akVar2 = this.cfY.cfP;
        String id = akVar2.afo().acV().getId();
        akVar3 = this.cfY.cfP;
        String name = akVar3.afo().acV().getName();
        akVar4 = this.cfY.cfP;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, akVar4.afo().acX().getId(), str, str2, str3)));
    }
}
