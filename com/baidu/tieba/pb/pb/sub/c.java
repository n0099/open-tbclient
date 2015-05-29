package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        s sVar;
        s sVar2;
        if (i == 26) {
            sVar2 = this.bPw.bPq;
            if (sVar2.Km()) {
                this.bPw.showToast(com.baidu.tieba.t.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bPw.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 27) {
            sVar = this.bPw.bPq;
            this.bPw.gg(sVar.adg());
        }
    }
}
