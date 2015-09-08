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
    private final /* synthetic */ long bKE;
    private final /* synthetic */ String bKF;
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ cw ccn;
    private final /* synthetic */ ShareFromPBMsgData cco;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity, cw cwVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ccj = pbActivity;
        this.ccn = cwVar;
        this.bKE = j;
        this.val$name = str;
        this.bKF = str2;
        this.cco = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ccj.HidenSoftKeyPad((InputMethodManager) this.ccj.getSystemService("input_method"), this.ccn.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ccj.getPageContext().getPageActivity(), this.bKE, this.val$name, this.bKF, 0, this.ccn.getLeaveMsg(), this.cco.toChatMessageContent())));
        aVar.dismiss();
    }
}
