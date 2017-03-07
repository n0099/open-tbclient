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
public class bh implements a.b {
    private final /* synthetic */ int cbJ;
    private final /* synthetic */ String cbK;
    private final /* synthetic */ long cbL;
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ gs elX;
    private final /* synthetic */ ShareFromPBMsgData elY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, gs gsVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.elO = pbActivity;
        this.elX = gsVar;
        this.cbJ = i;
        this.cbK = str;
        this.cbL = j;
        this.elY = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aKp;
        this.elO.HidenSoftKeyPad((InputMethodManager) this.elO.getSystemService("input_method"), this.elX.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.elO.getPageContext().getPageActivity(), this.cbJ, this.cbK, this.cbL, "from_share", this.elX.getLeaveMsg(), this.elY.toChatMessageContent())));
        aVar.dismiss();
        aKp = this.elO.aKp();
        if (aKp == 1) {
            this.elO.aKu();
        }
    }
}
