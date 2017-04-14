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
    private final /* synthetic */ long cah;
    private final /* synthetic */ String cai;
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ gq ekd;
    private final /* synthetic */ ShareFromPBMsgData eke;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, gq gqVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ejU = pbActivity;
        this.ekd = gqVar;
        this.cah = j;
        this.val$name = str;
        this.cai = str2;
        this.eke = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aKw;
        this.ejU.HidenSoftKeyPad((InputMethodManager) this.ejU.getSystemService("input_method"), this.ekd.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ejU.getPageContext().getPageActivity(), this.cah, this.val$name, this.cai, 0, this.ekd.getLeaveMsg(), this.eke.toChatMessageContent())));
        aVar.dismiss();
        aKw = this.ejU.aKw();
        if (aKw == 1) {
            this.ejU.aKB();
        }
    }
}
