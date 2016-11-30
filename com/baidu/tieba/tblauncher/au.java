package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ ae fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ae aeVar) {
        this.fGW = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fGW.fGL;
        ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(mainTabActivity.getPageContext().getPageActivity());
        mainTabActivity2 = this.fGW.fGL;
        mainTabActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
        TiebaStatic.log(new av("c11667").s("obj_locate", 1));
    }
}
