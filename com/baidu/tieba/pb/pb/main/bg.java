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
public class bg implements a.b {
    private final /* synthetic */ int bXi;
    private final /* synthetic */ String bXj;
    private final /* synthetic */ long bXk;
    private final /* synthetic */ ShareFromPBMsgData bXo;
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ gp evU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, gp gpVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.evL = pbActivity;
        this.evU = gpVar;
        this.bXi = i;
        this.bXj = str;
        this.bXk = j;
        this.bXo = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aPi;
        this.evL.HidenSoftKeyPad((InputMethodManager) this.evL.getSystemService("input_method"), this.evU.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.evL.getPageContext().getPageActivity(), this.bXi, this.bXj, this.bXk, "from_share", this.evU.getLeaveMsg(), this.bXo.toChatMessageContent())));
        aVar.dismiss();
        aPi = this.evL.aPi();
        if (aPi == 1) {
            this.evL.aPn();
        }
    }
}
