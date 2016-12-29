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
    private final /* synthetic */ int bDs;
    private final /* synthetic */ String bDt;
    private final /* synthetic */ long bDu;
    private final /* synthetic */ ShareFromPBMsgData bDy;
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ gi eaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, gi giVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.eah = pbActivity;
        this.eaq = giVar;
        this.bDs = i;
        this.bDt = str;
        this.bDu = j;
        this.bDy = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aJh;
        this.eah.HidenSoftKeyPad((InputMethodManager) this.eah.getSystemService("input_method"), this.eaq.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.eah.getPageContext().getPageActivity(), this.bDs, this.bDt, this.bDu, "from_share", this.eaq.getLeaveMsg(), this.bDy.toChatMessageContent())));
        aVar.dismiss();
        aJh = this.eah.aJh();
        if (aJh == 1) {
            this.eah.aJm();
        }
    }
}
