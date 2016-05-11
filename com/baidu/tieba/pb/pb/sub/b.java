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
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        ap apVar;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ap apVar5;
        ap apVar6;
        ap apVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.dqn.dqd;
            if (!aVar.aUI() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.h.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                apVar = this.dqn.dqc;
                if (apVar != null) {
                    apVar2 = this.dqn.dqc;
                    if (apVar2.aAn() != null) {
                        apVar3 = this.dqn.dqc;
                        if (apVar3.aAn().avV() != null) {
                            apVar4 = this.dqn.dqc;
                            if (apVar4.aAn().Kl() != null) {
                                aVar2 = this.dqn.dqd;
                                apVar5 = this.dqn.dqc;
                                String id = apVar5.aAn().avV().getId();
                                apVar6 = this.dqn.dqc;
                                String name = apVar6.aAn().avV().getName();
                                apVar7 = this.dqn.dqc;
                                aVar2.a(id, name, apVar7.aAn().Kl().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m11getInst().login(this.dqn.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.dqn.getPageContext().getPageActivity(), this.dqn.getPageContext().getString(t.j.login_to_use), true, 11017)));
    }
}
