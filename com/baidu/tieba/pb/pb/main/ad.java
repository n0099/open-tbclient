package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;
    private final /* synthetic */ dj bIK;
    private final /* synthetic */ ShareFromPBMsgData bIL;
    private final /* synthetic */ long btx;
    private final /* synthetic */ String bty;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, dj djVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bIJ = pbActivity;
        this.bIK = djVar;
        this.btx = j;
        this.val$name = str;
        this.bty = str2;
        this.bIL = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bIJ.HidenSoftKeyPad((InputMethodManager) this.bIJ.getSystemService("input_method"), this.bIK.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bIJ.getPageContext().getPageActivity(), this.btx, this.val$name, this.bty, 0, this.bIK.getLeaveMsg(), this.bIL.toChatMessageContent())));
        aVar.dismiss();
    }
}
