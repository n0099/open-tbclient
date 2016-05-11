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
public class ax implements a.b {
    private final /* synthetic */ long bhx;
    private final /* synthetic */ String bhy;
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ ga djJ;
    private final /* synthetic */ ShareFromPBMsgData djK;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity, ga gaVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.djE = pbActivity;
        this.djJ = gaVar;
        this.bhx = j;
        this.val$name = str;
        this.bhy = str2;
        this.djK = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int awy;
        this.djE.HidenSoftKeyPad((InputMethodManager) this.djE.getSystemService("input_method"), this.djJ.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.djE.getPageContext().getPageActivity(), this.bhx, this.val$name, this.bhy, 0, this.djJ.getLeaveMsg(), this.djK.toChatMessageContent())));
        aVar.dismiss();
        awy = this.djE.awy();
        if (awy == 1) {
            this.djE.awC();
        }
    }
}
