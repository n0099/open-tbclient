package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        bc bcVar6;
        bc bcVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        bcVar = this.eEs.eEb;
        if (bcVar.aTA() != null) {
            bcVar5 = this.eEs.eEb;
            if (bcVar5.aTA().Jz() != null) {
                bcVar6 = this.eEs.eEb;
                if (bcVar6.aTA().Jz().getAuthor() != null) {
                    bcVar7 = this.eEs.eEb;
                    str = String.valueOf(bcVar7.aTA().Jz().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.eEs;
        Activity pageActivity = this.eEs.getPageContext().getPageActivity();
        bcVar2 = this.eEs.eEb;
        String id = bcVar2.aTA().aOM().getId();
        bcVar3 = this.eEs.eEb;
        String name = bcVar3.aTA().aOM().getName();
        bcVar4 = this.eEs.eEb;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, bcVar4.aTA().Jz().getId(), str, str2, str3)));
    }
}
