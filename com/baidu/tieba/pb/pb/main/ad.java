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
    private final /* synthetic */ int aUM;
    private final /* synthetic */ String aUN;
    private final /* synthetic */ long aUO;
    private final /* synthetic */ cx ciD;
    private final /* synthetic */ ShareFromPBMsgData ciE;
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, cx cxVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ciz = pbActivity;
        this.ciD = cxVar;
        this.aUM = i;
        this.aUN = str;
        this.aUO = j;
        this.ciE = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciz.HidenSoftKeyPad((InputMethodManager) this.ciz.getSystemService("input_method"), this.ciD.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ciz.getPageContext().getPageActivity(), this.aUM, this.aUN, this.aUO, "from_share", this.ciD.getLeaveMsg(), this.ciE.toChatMessageContent())));
        aVar.dismiss();
    }
}
