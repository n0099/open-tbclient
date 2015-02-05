package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
/* loaded from: classes.dex */
class n implements d {
    private final /* synthetic */ BaseActivity baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BaseActivity baseActivity) {
        this.baY = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.baY.getPageContext().getPageActivity(), true, 23004, "remind")));
    }
}
