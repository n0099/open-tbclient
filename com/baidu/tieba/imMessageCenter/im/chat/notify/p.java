package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ f dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(f fVar) {
        this.dgY = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InviteFriendListActivityConfig((Context) this.dgY.getPageContext().getPageActivity(), true, true)));
        }
    }
}
