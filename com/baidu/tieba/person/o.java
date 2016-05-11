package com.baidu.tieba.person;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.person.EditHeadActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ EditHeadActivity.a dvf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EditHeadActivity.a aVar) {
        this.dvf = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        EditHeadActivity editHeadActivity;
        MessageManager messageManager = MessageManager.getInstance();
        editHeadActivity = EditHeadActivity.this;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(editHeadActivity.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
        aVar.dismiss();
    }
}
