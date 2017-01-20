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
public class bi implements a.b {
    private final /* synthetic */ int bUx;
    private final /* synthetic */ String bUy;
    private final /* synthetic */ long bUz;
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ gs eje;
    private final /* synthetic */ ShareFromPBMsgData ejf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, gs gsVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.eiV = pbActivity;
        this.eje = gsVar;
        this.bUx = i;
        this.bUy = str;
        this.bUz = j;
        this.ejf = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aKU;
        this.eiV.HidenSoftKeyPad((InputMethodManager) this.eiV.getSystemService("input_method"), this.eje.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.eiV.getPageContext().getPageActivity(), this.bUx, this.bUy, this.bUz, "from_share", this.eje.getLeaveMsg(), this.ejf.toChatMessageContent())));
        aVar.dismiss();
        aKU = this.eiV.aKU();
        if (aKU == 1) {
            this.eiV.aKZ();
        }
    }
}
