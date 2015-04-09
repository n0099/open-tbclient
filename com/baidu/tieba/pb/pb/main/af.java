package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ String bGn;
    private final /* synthetic */ int bGo;
    final /* synthetic */ PbActivity bIJ;
    private final /* synthetic */ dj bIK;
    private final /* synthetic */ ShareFromPBMsgData bIL;
    private final /* synthetic */ int blE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, dj djVar, int i, String str, int i2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bIJ = pbActivity;
        this.bIK = djVar;
        this.blE = i;
        this.bGn = str;
        this.bGo = i2;
        this.bIL = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bIJ.HidenSoftKeyPad((InputMethodManager) this.bIJ.getSystemService("input_method"), this.bIK.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bIJ.getPageContext().getPageActivity(), this.blE, this.bGn, this.bGo, "from_share", this.bIK.getLeaveMsg(), this.bIL.toChatMessageContent())));
        aVar.dismiss();
    }
}
