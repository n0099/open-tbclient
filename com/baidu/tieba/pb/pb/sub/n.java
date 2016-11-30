package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        bc bcVar5;
        bc bcVar6;
        bc bcVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.eEs.eEc;
            if (!aVar.bmU() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.h.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                bcVar = this.eEs.eEb;
                if (bcVar != null) {
                    bcVar2 = this.eEs.eEb;
                    if (bcVar2.aTA() != null) {
                        bcVar3 = this.eEs.eEb;
                        if (bcVar3.aTA().aOM() != null) {
                            bcVar4 = this.eEs.eEb;
                            if (bcVar4.aTA().Jz() != null) {
                                aVar2 = this.eEs.eEc;
                                bcVar5 = this.eEs.eEb;
                                String id = bcVar5.aTA().aOM().getId();
                                bcVar6 = this.eEs.eEb;
                                String name = bcVar6.aTA().aOM().getName();
                                bcVar7 = this.eEs.eEb;
                                aVar2.a(id, name, bcVar7.aTA().Jz().getId(), valueOf, g2, g, d);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        TbadkCoreApplication.m9getInst().login(this.eEs.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.eEs.getPageContext().getPageActivity(), this.eEs.getPageContext().getString(r.j.login_to_use), true, 11017)));
    }
}
