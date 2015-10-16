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
public class ad implements a.b {
    private final /* synthetic */ int aUX;
    private final /* synthetic */ String aUY;
    private final /* synthetic */ long aUZ;
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ cx ciO;
    private final /* synthetic */ ShareFromPBMsgData ciP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, cx cxVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ciK = pbActivity;
        this.ciO = cxVar;
        this.aUX = i;
        this.aUY = str;
        this.aUZ = j;
        this.ciP = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciK.HidenSoftKeyPad((InputMethodManager) this.ciK.getSystemService("input_method"), this.ciO.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ciK.getPageContext().getPageActivity(), this.aUX, this.aUY, this.aUZ, "from_share", this.ciO.getLeaveMsg(), this.ciP.toChatMessageContent())));
        aVar.dismiss();
    }
}
