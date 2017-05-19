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
    private final /* synthetic */ int cap;
    private final /* synthetic */ String caq;
    private final /* synthetic */ long car;
    private final /* synthetic */ gz ehH;
    private final /* synthetic */ ShareFromPBMsgData ehI;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity, gz gzVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ehy = pbActivity;
        this.ehH = gzVar;
        this.cap = i;
        this.caq = str;
        this.car = j;
        this.ehI = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aIR;
        this.ehy.HidenSoftKeyPad((InputMethodManager) this.ehy.getSystemService("input_method"), this.ehH.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ehy.getPageContext().getPageActivity(), this.cap, this.caq, this.car, "from_share", this.ehH.getLeaveMsg(), this.ehI.toChatMessageContent())));
        aVar.dismiss();
        aIR = this.ehy.aIR();
        if (aIR == 1) {
            this.ehy.aIX();
        }
    }
}
