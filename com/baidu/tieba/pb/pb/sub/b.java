package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
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
            aVar = this.cTK.cTA;
            if (!aVar.aNl() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean e = com.baidu.adp.lib.h.b.e(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                aoVar = this.cTK.cTz;
                if (aoVar != null) {
                    aoVar2 = this.cTK.cTz;
                    if (aoVar2.asw() != null) {
                        aoVar3 = this.cTK.cTz;
                        if (aoVar3.asw().aoX() != null) {
                            aoVar4 = this.cTK.cTz;
                            if (aoVar4.asw().Ki() != null) {
                                aVar2 = this.cTK.cTA;
                                aoVar5 = this.cTK.cTz;
                                String id = aoVar5.asw().aoX().getId();
                                aoVar6 = this.cTK.cTz;
                                String name = aoVar6.asw().aoX().getName();
                                aoVar7 = this.cTK.cTz;
                                aVar2.a(id, name, aoVar7.asw().Ki().getId(), valueOf, g2, g, e);
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
        TbadkCoreApplication.m411getInst().login(this.cTK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cTK.getPageContext().getPageActivity(), this.cTK.getPageContext().getString(t.j.login_to_use), true, 11017)));
    }
}
