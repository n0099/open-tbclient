package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
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
        bcVar = this.eis.eib;
        if (bcVar.aNr() != null) {
            bcVar5 = this.eis.eib;
            if (bcVar5.aNr().IU() != null) {
                bcVar6 = this.eis.eib;
                if (bcVar6.aNr().IU().getAuthor() != null) {
                    bcVar7 = this.eis.eib;
                    str = String.valueOf(bcVar7.aNr().IU().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.eis;
        Activity pageActivity = this.eis.getPageContext().getPageActivity();
        bcVar2 = this.eis.eib;
        String id = bcVar2.aNr().aIL().getId();
        bcVar3 = this.eis.eib;
        String name = bcVar3.aNr().aIL().getName();
        bcVar4 = this.eis.eib;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, bcVar4.aNr().IU().getId(), str, str2, str3)));
    }
}
