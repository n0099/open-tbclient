package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ String bJi;
    private final /* synthetic */ int bJj;
    final /* synthetic */ PbActivity bKT;
    private final /* synthetic */ dc bKU;
    private final /* synthetic */ ShareFromPBMsgData bKV;
    private final /* synthetic */ int boi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, dc dcVar, int i, String str, int i2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bKT = pbActivity;
        this.bKU = dcVar;
        this.boi = i;
        this.bJi = str;
        this.bJj = i2;
        this.bKV = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bKT.HidenSoftKeyPad((InputMethodManager) this.bKT.getSystemService("input_method"), this.bKU.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bKT.getPageContext().getPageActivity(), this.boi, this.bJi, this.bJj, "from_share", this.bKU.getLeaveMsg(), this.bKV.toChatMessageContent())));
        aVar.dismiss();
    }
}
