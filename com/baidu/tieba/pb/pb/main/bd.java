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
    private final /* synthetic */ String bGA;
    private final /* synthetic */ long bGB;
    private final /* synthetic */ int bGz;
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ gh dPK;
    private final /* synthetic */ ShareFromPBMsgData dPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, gh ghVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.dPF = pbActivity;
        this.dPK = ghVar;
        this.bGz = i;
        this.bGA = str;
        this.bGB = j;
        this.dPL = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int aEI;
        this.dPF.HidenSoftKeyPad((InputMethodManager) this.dPF.getSystemService("input_method"), this.dPK.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.dPF.getPageContext().getPageActivity(), this.bGz, this.bGA, this.bGB, "from_share", this.dPK.getLeaveMsg(), this.dPL.toChatMessageContent())));
        aVar.dismiss();
        aEI = this.dPF.aEI();
        if (aEI == 1) {
            this.dPF.aEM();
        }
    }
}
