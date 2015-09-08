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
    private final /* synthetic */ int bCD;
    private final /* synthetic */ String caa;
    private final /* synthetic */ long cab;
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ cw ccn;
    private final /* synthetic */ ShareFromPBMsgData cco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, cw cwVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ccj = pbActivity;
        this.ccn = cwVar;
        this.bCD = i;
        this.caa = str;
        this.cab = j;
        this.cco = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ccj.HidenSoftKeyPad((InputMethodManager) this.ccj.getSystemService("input_method"), this.ccn.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ccj.getPageContext().getPageActivity(), this.bCD, this.caa, this.cab, "from_share", this.ccn.getLeaveMsg(), this.cco.toChatMessageContent())));
        aVar.dismiss();
    }
}
