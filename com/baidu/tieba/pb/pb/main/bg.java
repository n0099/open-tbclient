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
public class bg implements a.b {
    private final /* synthetic */ long cam;
    private final /* synthetic */ String can;
    private final /* synthetic */ gz ehH;
    private final /* synthetic */ ShareFromPBMsgData ehI;
    final /* synthetic */ PbActivity ehy;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PbActivity pbActivity, gz gzVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ehy = pbActivity;
        this.ehH = gzVar;
        this.cam = j;
        this.val$name = str;
        this.can = str2;
        this.ehI = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aIR;
        this.ehy.HidenSoftKeyPad((InputMethodManager) this.ehy.getSystemService("input_method"), this.ehH.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ehy.getPageContext().getPageActivity(), this.cam, this.val$name, this.can, 0, this.ehH.getLeaveMsg(), this.ehI.toChatMessageContent())));
        aVar.dismiss();
        aIR = this.ehy.aIR();
        if (aIR == 1) {
            this.ehy.aIX();
        }
    }
}
