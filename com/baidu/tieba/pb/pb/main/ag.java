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
public class ag implements a.b {
    private final /* synthetic */ int aVf;
    private final /* synthetic */ String aVg;
    private final /* synthetic */ long aVh;
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ dp cjR;
    private final /* synthetic */ ShareFromPBMsgData cjS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, dp dpVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.cjN = pbActivity;
        this.cjR = dpVar;
        this.aVf = i;
        this.aVg = str;
        this.aVh = j;
        this.cjS = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cjN.HidenSoftKeyPad((InputMethodManager) this.cjN.getSystemService("input_method"), this.cjR.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cjN.getPageContext().getPageActivity(), this.aVf, this.aVg, this.aVh, "from_share", this.cjR.getLeaveMsg(), this.cjS.toChatMessageContent())));
        aVar.dismiss();
    }
}
