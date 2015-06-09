package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;
    private final /* synthetic */ dc bKV;
    private final /* synthetic */ ShareFromPBMsgData bKW;
    private final /* synthetic */ long bwh;
    private final /* synthetic */ String bwi;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity, dc dcVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bKU = pbActivity;
        this.bKV = dcVar;
        this.bwh = j;
        this.val$name = str;
        this.bwi = str2;
        this.bKW = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bKU.HidenSoftKeyPad((InputMethodManager) this.bKU.getSystemService("input_method"), this.bKV.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bKU.getPageContext().getPageActivity(), this.bwh, this.val$name, this.bwi, 0, this.bKV.getLeaveMsg(), this.bKW.toChatMessageContent())));
        aVar.dismiss();
    }
}
