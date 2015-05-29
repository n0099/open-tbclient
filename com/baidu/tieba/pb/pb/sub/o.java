package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements r {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
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
            aVar = this.bPw.bPo;
            if (!aVar.aps() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int i = com.baidu.adp.lib.g.c.toInt(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.c.d(String.valueOf(objArr[2]), false);
                int i2 = com.baidu.adp.lib.g.c.toInt(String.valueOf(objArr[3]), 0);
                akVar = this.bPw.bPn;
                if (akVar != null) {
                    akVar2 = this.bPw.bPn;
                    if (akVar2.adB() != null) {
                        akVar3 = this.bPw.bPn;
                        if (akVar3.adB().aaF() != null) {
                            akVar4 = this.bPw.bPn;
                            if (akVar4.adB().aaH() != null) {
                                aVar2 = this.bPw.bPo;
                                akVar5 = this.bPw.bPn;
                                String id = akVar5.adB().aaF().getId();
                                akVar6 = this.bPw.bPn;
                                String name = akVar6.adB().aaF().getName();
                                akVar7 = this.bPw.bPn;
                                aVar2.a(id, name, akVar7.adB().aaH().getId(), valueOf, i2, i, d);
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
        TbadkCoreApplication.m411getInst().login(this.bPw.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.bPw.getPageContext().getPageActivity(), this.bPw.getPageContext().getString(com.baidu.tieba.t.login_to_use), true, 11017)));
    }
}
