package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class b implements a.b {
    private final /* synthetic */ BaseActivity bFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseActivity baseActivity) {
        this.bFW = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) this.bFW.getPageContext().getPageActivity(), true, 23004, "remind")));
    }
}
