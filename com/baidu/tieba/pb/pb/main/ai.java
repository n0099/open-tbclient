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
public class ai implements a.b {
    private final /* synthetic */ int bas;
    private final /* synthetic */ String bat;
    private final /* synthetic */ long bau;
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ ef cCq;
    private final /* synthetic */ ShareFromPBMsgData cCr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity, ef efVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.cCm = pbActivity;
        this.cCq = efVar;
        this.bas = i;
        this.bat = str;
        this.bau = j;
        this.cCr = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cCm.HidenSoftKeyPad((InputMethodManager) this.cCm.getSystemService("input_method"), this.cCq.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cCm.getPageContext().getPageActivity(), this.bas, this.bat, this.bau, "from_share", this.cCq.getLeaveMsg(), this.cCr.toChatMessageContent())));
        aVar.dismiss();
    }
}
