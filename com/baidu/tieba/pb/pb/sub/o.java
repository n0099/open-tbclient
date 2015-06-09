package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements r {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.r
    public void c(Object obj) {
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
            aVar = this.bPx.bPp;
            if (!aVar.apt() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int i = com.baidu.adp.lib.g.c.toInt(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.c.d(String.valueOf(objArr[2]), false);
                int i2 = com.baidu.adp.lib.g.c.toInt(String.valueOf(objArr[3]), 0);
                akVar = this.bPx.bPo;
                if (akVar != null) {
                    akVar2 = this.bPx.bPo;
                    if (akVar2.adC() != null) {
                        akVar3 = this.bPx.bPo;
                        if (akVar3.adC().aaG() != null) {
                            akVar4 = this.bPx.bPo;
                            if (akVar4.adC().aaI() != null) {
                                aVar2 = this.bPx.bPp;
                                akVar5 = this.bPx.bPo;
                                String id = akVar5.adC().aaG().getId();
                                akVar6 = this.bPx.bPo;
                                String name = akVar6.adC().aaG().getName();
                                akVar7 = this.bPx.bPo;
                                aVar2.a(id, name, akVar7.adC().aaI().getId(), valueOf, i2, i, d);
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
        TbadkCoreApplication.m411getInst().login(this.bPx.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.bPx.getPageContext().getPageActivity(), this.bPx.getPageContext().getString(com.baidu.tieba.t.login_to_use), true, 11017)));
    }
}
