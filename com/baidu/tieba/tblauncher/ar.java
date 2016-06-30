package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ab abVar) {
        this.fbT = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.fbT.fbI;
        ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(mainTabActivity.getPageContext().getPageActivity());
        mainTabActivity2 = this.fbT.fbI;
        mainTabActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
    }
}
