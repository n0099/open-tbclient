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
public class bk implements a.b {
    private final /* synthetic */ long cgy;
    private final /* synthetic */ String cgz;
    private final /* synthetic */ ShareFromPBMsgData dlq;
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ hh enm;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity, hh hhVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.enc = pbActivity;
        this.enm = hhVar;
        this.cgy = j;
        this.val$name = str;
        this.cgz = str2;
        this.dlq = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aJJ;
        this.enc.HidenSoftKeyPad((InputMethodManager) this.enc.getSystemService("input_method"), this.enm.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.enc.getPageContext().getPageActivity(), this.cgy, this.val$name, this.cgz, 0, this.enm.getLeaveMsg(), this.dlq.toChatMessageContent())));
        aVar.dismiss();
        aJJ = this.enc.aJJ();
        if (aJJ == 1) {
            this.enc.aJP();
        }
    }
}
