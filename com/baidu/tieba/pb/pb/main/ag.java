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
public class ag implements a.b {
    private final /* synthetic */ long bao;
    private final /* synthetic */ String bap;
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ ef cCq;
    private final /* synthetic */ ShareFromPBMsgData cCr;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, ef efVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.cCm = pbActivity;
        this.cCq = efVar;
        this.bao = j;
        this.val$name = str;
        this.bap = str2;
        this.cCr = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cCm.HidenSoftKeyPad((InputMethodManager) this.cCm.getSystemService("input_method"), this.cCq.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cCm.getPageContext().getPageActivity(), this.bao, this.val$name, this.bap, 0, this.cCq.getLeaveMsg(), this.cCr.toChatMessageContent())));
        aVar.dismiss();
    }
}
