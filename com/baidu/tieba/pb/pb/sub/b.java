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
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ao aoVar5;
        ao aoVar6;
        ao aoVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.cLc.cKS;
            if (!aVar.aGg() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean e = com.baidu.adp.lib.h.b.e(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                aoVar = this.cLc.cKR;
                if (aoVar != null) {
                    aoVar2 = this.cLc.cKR;
                    if (aoVar2.anR() != null) {
                        aoVar3 = this.cLc.cKR;
                        if (aoVar3.anR().akZ() != null) {
                            aoVar4 = this.cLc.cKR;
                            if (aoVar4.anR().Iv() != null) {
                                aVar2 = this.cLc.cKS;
                                aoVar5 = this.cLc.cKR;
                                String id = aoVar5.anR().akZ().getId();
                                aoVar6 = this.cLc.cKR;
                                String name = aoVar6.anR().akZ().getName();
                                aoVar7 = this.cLc.cKR;
                                aVar2.a(id, name, aoVar7.anR().Iv().getId(), valueOf, g2, g, e);
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
        TbadkCoreApplication.m411getInst().login(this.cLc.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cLc.getPageContext().getPageActivity(), this.cLc.getPageContext().getString(n.j.login_to_use), true, 11017)));
    }
}
