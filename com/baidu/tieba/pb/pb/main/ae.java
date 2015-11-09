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
public class ae implements a.b {
    private final /* synthetic */ long aVc;
    private final /* synthetic */ String aVd;
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ dp cjR;
    private final /* synthetic */ ShareFromPBMsgData cjS;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, dp dpVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.cjN = pbActivity;
        this.cjR = dpVar;
        this.aVc = j;
        this.val$name = str;
        this.aVd = str2;
        this.cjS = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cjN.HidenSoftKeyPad((InputMethodManager) this.cjN.getSystemService("input_method"), this.cjR.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cjN.getPageContext().getPageActivity(), this.aVc, this.val$name, this.aVd, 0, this.cjR.getLeaveMsg(), this.cjS.toChatMessageContent())));
        aVar.dismiss();
    }
}
