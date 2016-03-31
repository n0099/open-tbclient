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
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
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
            aVar = this.doF.dov;
            if (!aVar.aUn() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.h.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.h.b.g(String.valueOf(objArr[3]), 0);
                apVar = this.doF.dou;
                if (apVar != null) {
                    apVar2 = this.doF.dou;
                    if (apVar2.aAg() != null) {
                        apVar3 = this.doF.dou;
                        if (apVar3.aAg().avP() != null) {
                            apVar4 = this.doF.dou;
                            if (apVar4.aAg().LC() != null) {
                                aVar2 = this.doF.dov;
                                apVar5 = this.doF.dou;
                                String id = apVar5.aAg().avP().getId();
                                apVar6 = this.doF.dou;
                                String name = apVar6.aAg().avP().getName();
                                apVar7 = this.doF.dou;
                                aVar2.a(id, name, apVar7.aAg().LC().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m411getInst().login(this.doF.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.doF.getPageContext().getPageActivity(), this.doF.getPageContext().getString(t.j.login_to_use), true, 11017)));
    }
}
