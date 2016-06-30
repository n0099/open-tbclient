package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements a.b {
    private final /* synthetic */ long bGw;
    private final /* synthetic */ String bGx;
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ gh dPK;
    private final /* synthetic */ ShareFromPBMsgData dPL;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity, gh ghVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.dPF = pbActivity;
        this.dPK = ghVar;
        this.bGw = j;
        this.val$name = str;
        this.bGx = str2;
        this.dPL = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int aEI;
        this.dPF.HidenSoftKeyPad((InputMethodManager) this.dPF.getSystemService("input_method"), this.dPK.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.dPF.getPageContext().getPageActivity(), this.bGw, this.val$name, this.bGx, 0, this.dPK.getLeaveMsg(), this.dPL.toChatMessageContent())));
        aVar.dismiss();
        aEI = this.dPF.aEI();
        if (aEI == 1) {
            this.dPF.aEM();
        }
    }
}
