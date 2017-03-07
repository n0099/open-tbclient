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
public class bf implements a.b {
    private final /* synthetic */ long cbG;
    private final /* synthetic */ String cbH;
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ gs elX;
    private final /* synthetic */ ShareFromPBMsgData elY;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, gs gsVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.elO = pbActivity;
        this.elX = gsVar;
        this.cbG = j;
        this.val$name = str;
        this.cbH = str2;
        this.elY = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aKp;
        this.elO.HidenSoftKeyPad((InputMethodManager) this.elO.getSystemService("input_method"), this.elX.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.elO.getPageContext().getPageActivity(), this.cbG, this.val$name, this.cbH, 0, this.elX.getLeaveMsg(), this.elY.toChatMessageContent())));
        aVar.dismiss();
        aKp = this.elO.aKp();
        if (aKp == 1) {
            this.elO.aKu();
        }
    }
}
