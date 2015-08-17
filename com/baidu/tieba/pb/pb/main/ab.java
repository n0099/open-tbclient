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
public class ab implements a.b {
    private final /* synthetic */ long bJX;
    private final /* synthetic */ String bJY;
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ cw cbs;
    private final /* synthetic */ ShareFromPBMsgData cbt;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity, cw cwVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.cbo = pbActivity;
        this.cbs = cwVar;
        this.bJX = j;
        this.val$name = str;
        this.bJY = str2;
        this.cbt = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cbo.HidenSoftKeyPad((InputMethodManager) this.cbo.getSystemService("input_method"), this.cbs.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cbo.getPageContext().getPageActivity(), this.bJX, this.val$name, this.bJY, 0, this.cbs.getLeaveMsg(), this.cbt.toChatMessageContent())));
        aVar.dismiss();
    }
}
