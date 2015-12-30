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
public class ah implements a.b {
    private final /* synthetic */ long ben;
    private final /* synthetic */ String beo;
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ ep cFW;
    private final /* synthetic */ ShareFromPBMsgData cFX;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, ep epVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.cFS = pbActivity;
        this.cFW = epVar;
        this.ben = j;
        this.val$name = str;
        this.beo = str2;
        this.cFX = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cFS.HidenSoftKeyPad((InputMethodManager) this.cFS.getSystemService("input_method"), this.cFW.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cFS.getPageContext().getPageActivity(), this.ben, this.val$name, this.beo, 0, this.cFW.getLeaveMsg(), this.cFX.toChatMessageContent())));
        aVar.dismiss();
    }
}
