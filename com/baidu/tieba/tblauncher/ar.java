package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ab foX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ab abVar) {
        this.foX = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.foX.foM;
        ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(mainTabActivity.getPageContext().getPageActivity());
        mainTabActivity2 = this.foX.foM;
        mainTabActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
    }
}
