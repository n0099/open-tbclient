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
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
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
            forumManageModel = this.eye.exO;
            if (!forumManageModel.biS() && objArr != null && objArr.length >= 4) {
                String valueOf = String.valueOf(objArr[0]);
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[1]), 0);
                boolean d = com.baidu.adp.lib.g.b.d(String.valueOf(objArr[2]), false);
                int g2 = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[3]), 0);
                subPbModel = this.eye.exN;
                if (subPbModel != null) {
                    subPbModel2 = this.eye.exN;
                    if (subPbModel2.aOn() != null) {
                        subPbModel3 = this.eye.exN;
                        if (subPbModel3.aOn().aJp() != null) {
                            subPbModel4 = this.eye.exN;
                            if (subPbModel4.aOn().LH() != null) {
                                forumManageModel2 = this.eye.exO;
                                subPbModel5 = this.eye.exN;
                                String id = subPbModel5.aOn().aJp().getId();
                                subPbModel6 = this.eye.exN;
                                String name = subPbModel6.aOn().aJp().getName();
                                subPbModel7 = this.eye.exN;
                                forumManageModel2.a(id, name, subPbModel7.aOn().LH().getId(), valueOf, g2, g, d);
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
        TbadkCoreApplication.m9getInst().login(this.eye.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.eye.getPageContext().getPageActivity(), this.eye.getPageContext().getString(w.l.login_to_use), true, 11017)));
    }
}
