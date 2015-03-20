package com.baidu.tieba.tbadkCore.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ BaseActivity bda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseActivity baseActivity) {
        this.bda = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.bda.getPageContext().getPageActivity(), true, 23004, "remind")));
    }
}
