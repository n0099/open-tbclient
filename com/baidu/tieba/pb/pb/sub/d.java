package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        aw awVar5;
        aw awVar6;
        aw awVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.dWP.dWD;
            if (!aVar.bdc() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.h.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                awVar = this.dWP.dWC;
                if (awVar != null) {
                    awVar2 = this.dWP.dWC;
                    if (awVar2.aIH() != null) {
                        awVar3 = this.dWP.dWC;
                        if (awVar3.aIH().aEl() != null) {
                            awVar4 = this.dWP.dWC;
                            if (awVar4.aIH().Ix() != null) {
                                aVar2 = this.dWP.dWD;
                                awVar5 = this.dWP.dWC;
                                String id = awVar5.aIH().aEl().getId();
                                awVar6 = this.dWP.dWC;
                                String name = awVar6.aIH().aEl().getName();
                                awVar7 = this.dWP.dWC;
                                aVar2.a(id, name, awVar7.aIH().Ix().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m9getInst().login(this.dWP.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.dWP.getPageContext().getPageActivity(), this.dWP.getPageContext().getString(u.j.login_to_use), true, 11017)));
    }
}
