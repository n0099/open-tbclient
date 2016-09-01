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
public class bf implements a.b {
    private final /* synthetic */ int bTb;
    private final /* synthetic */ String bTc;
    private final /* synthetic */ long bTd;
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ gm eoh;
    private final /* synthetic */ ShareFromPBMsgData eoi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, gm gmVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.eob = pbActivity;
        this.eoh = gmVar;
        this.bTb = i;
        this.bTc = str;
        this.bTd = j;
        this.eoi = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aML;
        this.eob.HidenSoftKeyPad((InputMethodManager) this.eob.getSystemService("input_method"), this.eoh.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.eob.getPageContext().getPageActivity(), this.bTb, this.bTc, this.bTd, "from_share", this.eoh.getLeaveMsg(), this.eoi.toChatMessageContent())));
        aVar.dismiss();
        aML = this.eob.aML();
        if (aML == 1) {
            this.eob.aMP();
        }
    }
}
