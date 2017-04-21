package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements a.b {
    private final /* synthetic */ long ccy;
    private final /* synthetic */ String ccz;
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ gq emt;
    private final /* synthetic */ ShareFromPBMsgData emu;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, gq gqVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.emk = pbActivity;
        this.emt = gqVar;
        this.ccy = j;
        this.val$name = str;
        this.ccz = str2;
        this.emu = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aLw;
        this.emk.HidenSoftKeyPad((InputMethodManager) this.emk.getSystemService("input_method"), this.emt.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.emk.getPageContext().getPageActivity(), this.ccy, this.val$name, this.ccz, 0, this.emt.getLeaveMsg(), this.emu.toChatMessageContent())));
        aVar.dismiss();
        aLw = this.emk.aLw();
        if (aLw == 1) {
            this.emk.aLB();
        }
    }
}
