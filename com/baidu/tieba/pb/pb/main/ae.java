package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ String bGa;
    private final /* synthetic */ int bGb;
    final /* synthetic */ PbActivity bIv;
    private final /* synthetic */ di bIw;
    private final /* synthetic */ ShareFromPBMsgData bIx;
    private final /* synthetic */ int blo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, di diVar, int i, String str, int i2, ShareFromPBMsgData shareFromPBMsgData) {
        this.bIv = pbActivity;
        this.bIw = diVar;
        this.blo = i;
        this.bGa = str;
        this.bGb = i2;
        this.bIx = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bIv.HidenSoftKeyPad((InputMethodManager) this.bIv.getSystemService("input_method"), this.bIw.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bIv.getPageContext().getPageActivity(), this.blo, this.bGa, this.bGb, "from_share", this.bIw.getLeaveMsg(), this.bIx.toChatMessageContent())));
        aVar.dismiss();
    }
}
