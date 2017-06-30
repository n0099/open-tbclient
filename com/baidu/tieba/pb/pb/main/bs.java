package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements a.b {
    private final /* synthetic */ int coR;
    private final /* synthetic */ String coS;
    private final /* synthetic */ long coT;
    private final /* synthetic */ ShareFromPBMsgData dtm;
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ ht ewr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PbActivity pbActivity, ht htVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ewh = pbActivity;
        this.ewr = htVar;
        this.coR = i;
        this.coS = str;
        this.coT = j;
        this.dtm = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aNE;
        this.ewh.HidenSoftKeyPad((InputMethodManager) this.ewh.getSystemService("input_method"), this.ewr.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ewh.getPageContext().getPageActivity(), this.coR, this.coS, this.coT, "from_share", this.ewr.getLeaveMsg(), this.dtm.toChatMessageContent())));
        aVar.dismiss();
        aNE = this.ewh.aNE();
        if (aNE == 1) {
            this.ewh.aNL();
        }
    }
}
