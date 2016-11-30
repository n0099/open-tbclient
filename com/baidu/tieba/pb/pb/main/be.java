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
    private final /* synthetic */ long bXm;
    private final /* synthetic */ String bXn;
    private final /* synthetic */ ShareFromPBMsgData bXo;
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ gp evU;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, gp gpVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.evL = pbActivity;
        this.evU = gpVar;
        this.bXm = j;
        this.val$name = str;
        this.bXn = str2;
        this.bXo = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aPi;
        this.evL.HidenSoftKeyPad((InputMethodManager) this.evL.getSystemService("input_method"), this.evU.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.evL.getPageContext().getPageActivity(), this.bXm, this.val$name, this.bXn, 0, this.evU.getLeaveMsg(), this.bXo.toChatMessageContent())));
        aVar.dismiss();
        aPi = this.evL.aPi();
        if (aPi == 1) {
            this.evL.aPn();
        }
    }
}
