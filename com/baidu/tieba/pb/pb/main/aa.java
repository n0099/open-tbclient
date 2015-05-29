package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;
    private final /* synthetic */ dc bKU;
    private final /* synthetic */ ShareFromPBMsgData bKV;
    private final /* synthetic */ long bwg;
    private final /* synthetic */ String bwh;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity, dc dcVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bKT = pbActivity;
        this.bKU = dcVar;
        this.bwg = j;
        this.val$name = str;
        this.bwh = str2;
        this.bKV = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bKT.HidenSoftKeyPad((InputMethodManager) this.bKT.getSystemService("input_method"), this.bKU.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bKT.getPageContext().getPageActivity(), this.bwg, this.val$name, this.bwh, 0, this.bKU.getLeaveMsg(), this.bKV.toChatMessageContent())));
        aVar.dismiss();
    }
}
