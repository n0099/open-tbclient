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
public class aj implements a.b {
    private final /* synthetic */ int beq;
    private final /* synthetic */ String ber;
    private final /* synthetic */ long bes;
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ ep cFW;
    private final /* synthetic */ ShareFromPBMsgData cFX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity, ep epVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.cFS = pbActivity;
        this.cFW = epVar;
        this.beq = i;
        this.ber = str;
        this.bes = j;
        this.cFX = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cFS.HidenSoftKeyPad((InputMethodManager) this.cFS.getSystemService("input_method"), this.cFW.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cFS.getPageContext().getPageActivity(), this.beq, this.ber, this.bes, "from_share", this.cFW.getLeaveMsg(), this.cFX.toChatMessageContent())));
        aVar.dismiss();
    }
}
