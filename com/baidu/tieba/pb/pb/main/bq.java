package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dh dhVar;
        this.eob.sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.eob.getPageContext().getPageActivity(), 23003)));
        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10125");
        dhVar = this.eob.emx;
        TiebaStatic.log(ayVar.ab("tid", dhVar.getThreadID()).s("obj_type", 2));
    }
}
