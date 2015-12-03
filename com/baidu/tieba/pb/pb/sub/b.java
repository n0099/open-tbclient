package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        an anVar5;
        an anVar6;
        an anVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.cHd.cGT;
            if (!aVar.aDT() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean e = com.baidu.adp.lib.h.b.e(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                anVar = this.cHd.cGS;
                if (anVar != null) {
                    anVar2 = this.cHd.cGS;
                    if (anVar2.amF() != null) {
                        anVar3 = this.cHd.cGS;
                        if (anVar3.amF().ajR() != null) {
                            anVar4 = this.cHd.cGS;
                            if (anVar4.amF().ajT() != null) {
                                aVar2 = this.cHd.cGT;
                                anVar5 = this.cHd.cGS;
                                String id = anVar5.amF().ajR().getId();
                                anVar6 = this.cHd.cGS;
                                String name = anVar6.amF().ajR().getName();
                                anVar7 = this.cHd.cGS;
                                aVar2.a(id, name, anVar7.amF().ajT().getId(), valueOf, g2, g, e);
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
        TbadkCoreApplication.m411getInst().login(this.cHd.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cHd.getPageContext().getPageActivity(), this.cHd.getPageContext().getString(n.i.login_to_use), true, 11017)));
    }
}
