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
public class bn implements a.b {
    private final /* synthetic */ int cgB;
    private final /* synthetic */ String cgC;
    private final /* synthetic */ long cgD;
    private final /* synthetic */ ShareFromPBMsgData dlq;
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ hh enm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity, hh hhVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.enc = pbActivity;
        this.enm = hhVar;
        this.cgB = i;
        this.cgC = str;
        this.cgD = j;
        this.dlq = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aJJ;
        this.enc.HidenSoftKeyPad((InputMethodManager) this.enc.getSystemService("input_method"), this.enm.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.enc.getPageContext().getPageActivity(), this.cgB, this.cgC, this.cgD, "from_share", this.enm.getLeaveMsg(), this.dlq.toChatMessageContent())));
        aVar.dismiss();
        aJJ = this.enc.aJJ();
        if (aJJ == 1) {
            this.enc.aJP();
        }
    }
}
