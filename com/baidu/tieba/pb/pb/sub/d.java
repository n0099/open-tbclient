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
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
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
            aVar = this.ejr.ejf;
            if (!aVar.bgr() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.h.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                awVar = this.ejr.eje;
                if (awVar != null) {
                    awVar2 = this.ejr.eje;
                    if (awVar2.aLS() != null) {
                        awVar3 = this.ejr.eje;
                        if (awVar3.aLS().aHv() != null) {
                            awVar4 = this.ejr.eje;
                            if (awVar4.aLS().Iw() != null) {
                                aVar2 = this.ejr.ejf;
                                awVar5 = this.ejr.eje;
                                String id = awVar5.aLS().aHv().getId();
                                awVar6 = this.ejr.eje;
                                String name = awVar6.aLS().aHv().getName();
                                awVar7 = this.ejr.eje;
                                aVar2.a(id, name, awVar7.aLS().Iw().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m10getInst().login(this.ejr.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.ejr.getPageContext().getPageActivity(), this.ejr.getPageContext().getString(u.j.login_to_use), true, 11017)));
    }
}
