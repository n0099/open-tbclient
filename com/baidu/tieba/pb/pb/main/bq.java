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
public class bq implements a.b {
    private final /* synthetic */ long coO;
    private final /* synthetic */ String coP;
    private final /* synthetic */ ShareFromPBMsgData dtm;
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ ht ewr;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity, ht htVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ewh = pbActivity;
        this.ewr = htVar;
        this.coO = j;
        this.val$name = str;
        this.coP = str2;
        this.dtm = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aNE;
        this.ewh.HidenSoftKeyPad((InputMethodManager) this.ewh.getSystemService("input_method"), this.ewr.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ewh.getPageContext().getPageActivity(), this.coO, this.val$name, this.coP, 0, this.ewr.getLeaveMsg(), this.dtm.toChatMessageContent())));
        aVar.dismiss();
        aNE = this.ewh.aNE();
        if (aNE == 1) {
            this.ewh.aNL();
        }
    }
}
