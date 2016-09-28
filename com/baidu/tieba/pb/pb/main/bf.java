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
public class bf implements a.b {
    private final /* synthetic */ int bSU;
    private final /* synthetic */ String bSV;
    private final /* synthetic */ long bSW;
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ gm eqf;
    private final /* synthetic */ ShareFromPBMsgData eqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, gm gmVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.eqa = pbActivity;
        this.eqf = gmVar;
        this.bSU = i;
        this.bSV = str;
        this.bSW = j;
        this.eqg = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aNr;
        this.eqa.HidenSoftKeyPad((InputMethodManager) this.eqa.getSystemService("input_method"), this.eqf.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.eqa.getPageContext().getPageActivity(), this.bSU, this.bSV, this.bSW, "from_share", this.eqf.getLeaveMsg(), this.eqg.toChatMessageContent())));
        aVar.dismiss();
        aNr = this.eqa.aNr();
        if (aNr == 1) {
            this.eqa.aNv();
        }
    }
}
