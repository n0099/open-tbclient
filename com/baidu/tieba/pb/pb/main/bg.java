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
public class bg implements a.b {
    private final /* synthetic */ long bUu;
    private final /* synthetic */ String bUv;
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ gs eje;
    private final /* synthetic */ ShareFromPBMsgData ejf;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, gs gsVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.eiV = pbActivity;
        this.eje = gsVar;
        this.bUu = j;
        this.val$name = str;
        this.bUv = str2;
        this.ejf = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aKU;
        this.eiV.HidenSoftKeyPad((InputMethodManager) this.eiV.getSystemService("input_method"), this.eje.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.eiV.getPageContext().getPageActivity(), this.bUu, this.val$name, this.bUv, 0, this.eje.getLeaveMsg(), this.ejf.toChatMessageContent())));
        aVar.dismiss();
        aKU = this.eiV.aKU();
        if (aKU == 1) {
            this.eiV.aKZ();
        }
    }
}
