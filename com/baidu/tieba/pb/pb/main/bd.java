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
public class bd implements a.b {
    private final /* synthetic */ long bSY;
    private final /* synthetic */ String bSZ;
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ gm eoh;
    private final /* synthetic */ ShareFromPBMsgData eoi;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity, gm gmVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.eob = pbActivity;
        this.eoh = gmVar;
        this.bSY = j;
        this.val$name = str;
        this.bSZ = str2;
        this.eoi = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aML;
        this.eob.HidenSoftKeyPad((InputMethodManager) this.eob.getSystemService("input_method"), this.eoh.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.eob.getPageContext().getPageActivity(), this.bSY, this.val$name, this.bSZ, 0, this.eoh.getLeaveMsg(), this.eoi.toChatMessageContent())));
        aVar.dismiss();
        aML = this.eob.aML();
        if (aML == 1) {
            this.eob.aMP();
        }
    }
}
