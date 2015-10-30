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
public class s implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.g.a aVar;
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.cmC.cmu;
            if (!aVar.axs() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                akVar = this.cmC.cmt;
                if (akVar != null) {
                    akVar2 = this.cmC.cmt;
                    if (akVar2.ahw() != null) {
                        akVar3 = this.cmC.cmt;
                        if (akVar3.ahw().afc() != null) {
                            akVar4 = this.cmC.cmt;
                            if (akVar4.ahw().afe() != null) {
                                aVar2 = this.cmC.cmu;
                                akVar5 = this.cmC.cmt;
                                String id = akVar5.ahw().afc().getId();
                                akVar6 = this.cmC.cmt;
                                String name = akVar6.ahw().afc().getName();
                                akVar7 = this.cmC.cmt;
                                aVar2.a(id, name, akVar7.ahw().afe().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m411getInst().login(this.cmC.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cmC.getPageContext().getPageActivity(), this.cmC.getPageContext().getString(i.h.login_to_use), true, 11017)));
    }
}
