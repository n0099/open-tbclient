package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ab fzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ab abVar) {
        this.fzu = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fzu.fzj;
        ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(mainTabActivity.getPageContext().getPageActivity());
        mainTabActivity2 = this.fzu.fzj;
        mainTabActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
        TiebaStatic.log(new ax("c11667").s("obj_locate", 1));
    }
}
