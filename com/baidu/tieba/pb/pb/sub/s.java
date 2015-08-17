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
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.h.a aVar;
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.cfY.cfQ;
            if (!aVar.aqN() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                akVar = this.cfY.cfP;
                if (akVar != null) {
                    akVar2 = this.cfY.cfP;
                    if (akVar2.afo() != null) {
                        akVar3 = this.cfY.cfP;
                        if (akVar3.afo().acV() != null) {
                            akVar4 = this.cfY.cfP;
                            if (akVar4.afo().acX() != null) {
                                aVar2 = this.cfY.cfQ;
                                akVar5 = this.cfY.cfP;
                                String id = akVar5.afo().acV().getId();
                                akVar6 = this.cfY.cfP;
                                String name = akVar6.afo().acV().getName();
                                akVar7 = this.cfY.cfP;
                                aVar2.a(id, name, akVar7.afo().acX().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m411getInst().login(this.cfY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cfY.getPageContext().getPageActivity(), this.cfY.getPageContext().getString(i.C0057i.login_to_use), true, 11017)));
    }
}
