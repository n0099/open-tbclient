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
public class bd implements a.b {
    private final /* synthetic */ long bSR;
    private final /* synthetic */ String bSS;
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ gm eqf;
    private final /* synthetic */ ShareFromPBMsgData eqg;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, gm gmVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.eqa = pbActivity;
        this.eqf = gmVar;
        this.bSR = j;
        this.val$name = str;
        this.bSS = str2;
        this.eqg = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aNr;
        this.eqa.HidenSoftKeyPad((InputMethodManager) this.eqa.getSystemService("input_method"), this.eqf.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.eqa.getPageContext().getPageActivity(), this.bSR, this.val$name, this.bSS, 0, this.eqf.getLeaveMsg(), this.eqg.toChatMessageContent())));
        aVar.dismiss();
        aNr = this.eqa.aNr();
        if (aNr == 1) {
            this.eqa.aNv();
        }
    }
}
