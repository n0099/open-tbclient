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
public class bd implements a.b {
    private final /* synthetic */ int bHV;
    private final /* synthetic */ String bHW;
    private final /* synthetic */ long bHX;
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ gl ebY;
    private final /* synthetic */ ShareFromPBMsgData ebZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, gl glVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ebT = pbActivity;
        this.ebY = glVar;
        this.bHV = i;
        this.bHW = str;
        this.bHX = j;
        this.ebZ = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int aHT;
        this.ebT.HidenSoftKeyPad((InputMethodManager) this.ebT.getSystemService("input_method"), this.ebY.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ebT.getPageContext().getPageActivity(), this.bHV, this.bHW, this.bHX, "from_share", this.ebY.getLeaveMsg(), this.ebZ.toChatMessageContent())));
        aVar.dismiss();
        aHT = this.ebT.aHT();
        if (aHT == 1) {
            this.ebT.aHX();
        }
    }
}
