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
public class be implements a.b {
    private final /* synthetic */ long bDw;
    private final /* synthetic */ String bDx;
    private final /* synthetic */ ShareFromPBMsgData bDy;
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ gi eaq;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, gi giVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.eah = pbActivity;
        this.eaq = giVar;
        this.bDw = j;
        this.val$name = str;
        this.bDx = str2;
        this.bDy = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aJh;
        this.eah.HidenSoftKeyPad((InputMethodManager) this.eah.getSystemService("input_method"), this.eaq.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.eah.getPageContext().getPageActivity(), this.bDw, this.val$name, this.bDx, 0, this.eaq.getLeaveMsg(), this.bDy.toChatMessageContent())));
        aVar.dismiss();
        aJh = this.eah.aJh();
        if (aJh == 1) {
            this.eah.aJm();
        }
    }
}
