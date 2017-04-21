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
public class bh implements a.b {
    private final /* synthetic */ int ccB;
    private final /* synthetic */ String ccC;
    private final /* synthetic */ long ccD;
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ gq emt;
    private final /* synthetic */ ShareFromPBMsgData emu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, gq gqVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.emk = pbActivity;
        this.emt = gqVar;
        this.ccB = i;
        this.ccC = str;
        this.ccD = j;
        this.emu = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aLw;
        this.emk.HidenSoftKeyPad((InputMethodManager) this.emk.getSystemService("input_method"), this.emt.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.emk.getPageContext().getPageActivity(), this.ccB, this.ccC, this.ccD, "from_share", this.emt.getLeaveMsg(), this.emu.toChatMessageContent())));
        aVar.dismiss();
        aLw = this.emk.aLw();
        if (aLw == 1) {
            this.emk.aLB();
        }
    }
}
