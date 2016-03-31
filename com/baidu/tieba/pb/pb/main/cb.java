package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        df dfVar;
        this.dht.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.dht.getPageContext().getPageActivity(), 23003)));
        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10125");
        dfVar = this.dht.dfV;
        TiebaStatic.log(awVar.ac("tid", dfVar.getThreadID()).r("obj_type", 2));
    }
}
