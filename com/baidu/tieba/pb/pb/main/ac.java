package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ String bJj;
    private final /* synthetic */ int bJk;
    final /* synthetic */ PbActivity bKU;
    private final /* synthetic */ dc bKV;
    private final /* synthetic */ ShareFromPBMsgData bKW;
    private final /* synthetic */ int boj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, dc dcVar, int i, String str, int i2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bKU = pbActivity;
        this.bKV = dcVar;
        this.boj = i;
        this.bJj = str;
        this.bJk = i2;
        this.bKW = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bKU.HidenSoftKeyPad((InputMethodManager) this.bKU.getSystemService("input_method"), this.bKV.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bKU.getPageContext().getPageActivity(), this.boj, this.bJj, this.bJk, "from_share", this.bKV.getLeaveMsg(), this.bKW.toChatMessageContent())));
        aVar.dismiss();
    }
}
