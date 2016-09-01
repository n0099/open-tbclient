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
public class e implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            aVar = this.evy.evm;
            if (!aVar.bjS() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.h.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                axVar = this.evy.evl;
                if (axVar != null) {
                    axVar2 = this.evy.evl;
                    if (axVar2.aQK() != null) {
                        axVar3 = this.evy.evl;
                        if (axVar3.aQK().aMn() != null) {
                            axVar4 = this.evy.evl;
                            if (axVar4.aQK().Kw() != null) {
                                aVar2 = this.evy.evm;
                                axVar5 = this.evy.evl;
                                String id = axVar5.aQK().aMn().getId();
                                axVar6 = this.evy.evl;
                                String name = axVar6.aQK().aMn().getName();
                                axVar7 = this.evy.evl;
                                aVar2.a(id, name, axVar7.aQK().Kw().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m9getInst().login(this.evy.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.evy.getPageContext().getPageActivity(), this.evy.getPageContext().getString(t.j.login_to_use), true, 11017)));
    }
}
