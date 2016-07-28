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
public class bb implements a.b {
    private final /* synthetic */ long bHS;
    private final /* synthetic */ String bHT;
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ gl ebY;
    private final /* synthetic */ ShareFromPBMsgData ebZ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity, gl glVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ebT = pbActivity;
        this.ebY = glVar;
        this.bHS = j;
        this.val$name = str;
        this.bHT = str2;
        this.ebZ = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int aHT;
        this.ebT.HidenSoftKeyPad((InputMethodManager) this.ebT.getSystemService("input_method"), this.ebY.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ebT.getPageContext().getPageActivity(), this.bHS, this.val$name, this.bHT, 0, this.ebY.getLeaveMsg(), this.ebZ.toChatMessageContent())));
        aVar.dismiss();
        aHT = this.ebT.aHT();
        if (aHT == 1) {
            this.ebT.aHX();
        }
    }
}
