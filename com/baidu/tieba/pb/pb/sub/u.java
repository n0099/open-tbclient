package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.h.a aVar;
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        am amVar5;
        am amVar6;
        am amVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.cnS.cnI;
            if (!aVar.ayB() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                amVar = this.cnS.cnH;
                if (amVar != null) {
                    amVar2 = this.cnS.cnH;
                    if (amVar2.aic() != null) {
                        amVar3 = this.cnS.cnH;
                        if (amVar3.aic().afz() != null) {
                            amVar4 = this.cnS.cnH;
                            if (amVar4.aic().afB() != null) {
                                aVar2 = this.cnS.cnI;
                                amVar5 = this.cnS.cnH;
                                String id = amVar5.aic().afz().getId();
                                amVar6 = this.cnS.cnH;
                                String name = amVar6.aic().afz().getName();
                                amVar7 = this.cnS.cnH;
                                aVar2.a(id, name, amVar7.aic().afB().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m411getInst().login(this.cnS.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cnS.getPageContext().getPageActivity(), this.cnS.getPageContext().getString(i.h.login_to_use), true, 11017)));
    }
}
