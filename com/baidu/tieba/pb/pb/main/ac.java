package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;
    private final /* synthetic */ di bIw;
    private final /* synthetic */ ShareFromPBMsgData bIx;
    private final /* synthetic */ long btg;
    private final /* synthetic */ String bth;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, di diVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bIv = pbActivity;
        this.bIw = diVar;
        this.btg = j;
        this.val$name = str;
        this.bth = str2;
        this.bIx = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bIv.HidenSoftKeyPad((InputMethodManager) this.bIv.getSystemService("input_method"), this.bIw.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bIv.getPageContext().getPageActivity(), this.btg, this.val$name, this.bth, 0, this.bIw.getLeaveMsg(), this.bIx.toChatMessageContent())));
        aVar.dismiss();
    }
}
