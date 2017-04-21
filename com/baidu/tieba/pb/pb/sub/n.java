package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        ForumManageModel forumManageModel;
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
        ForumManageModel forumManageModel2;
        SubPbModel subPbModel5;
        SubPbModel subPbModel6;
        SubPbModel subPbModel7;
        Object[] objArr = (Object[]) obj;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            forumManageModel = this.evm.euW;
            if (!forumManageModel.bkb() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                subPbModel = this.evm.euV;
                if (subPbModel != null) {
                    subPbModel2 = this.evm.euV;
                    if (subPbModel2.aPO() != null) {
                        subPbModel3 = this.evm.euV;
                        if (subPbModel3.aPO().aLc() != null) {
                            subPbModel4 = this.evm.euV;
                            if (subPbModel4.aPO().Kn() != null) {
                                forumManageModel2 = this.evm.euW;
                                subPbModel5 = this.evm.euV;
                                String id = subPbModel5.aPO().aLc().getId();
                                subPbModel6 = this.evm.euV;
                                String name = subPbModel6.aPO().aLc().getName();
                                subPbModel7 = this.evm.euV;
                                forumManageModel2.a(id, name, subPbModel7.aPO().Kn().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m9getInst().login(this.evm.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.evm.getPageContext().getPageActivity(), this.evm.getPageContext().getString(w.l.login_to_use), true, 11017)));
    }
}
