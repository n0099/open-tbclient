package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        s sVar;
        s sVar2;
        if (i == 26) {
            sVar2 = this.bPx.bPr;
            if (sVar2.Kn()) {
                this.bPx.showToast(com.baidu.tieba.t.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bPx.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 27) {
            sVar = this.bPx.bPr;
            this.bPx.gg(sVar.adh());
        }
    }
}
