package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements a.b {
    private final /* synthetic */ int bBW;
    private final /* synthetic */ String bZg;
    private final /* synthetic */ long bZh;
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ cw cbs;
    private final /* synthetic */ ShareFromPBMsgData cbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, cw cwVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.cbo = pbActivity;
        this.cbs = cwVar;
        this.bBW = i;
        this.bZg = str;
        this.bZh = j;
        this.cbt = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cbo.HidenSoftKeyPad((InputMethodManager) this.cbo.getSystemService("input_method"), this.cbs.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cbo.getPageContext().getPageActivity(), this.bBW, this.bZg, this.bZh, "from_share", this.cbs.getLeaveMsg(), this.cbt.toChatMessageContent())));
        aVar.dismiss();
    }
}
