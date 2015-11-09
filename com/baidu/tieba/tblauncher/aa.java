package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        popupWindow = this.this$0.deC;
        com.baidu.adp.lib.g.j.a(popupWindow, this.this$0.getPageContext().getPageActivity());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyLiveActivityConfig(this.this$0.getPageContext().getPageActivity())));
    }
}
