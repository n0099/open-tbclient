package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    private final /* synthetic */ int bgL;
    private final /* synthetic */ String bgM;
    private final /* synthetic */ long bgN;
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ fm cNu;
    private final /* synthetic */ ShareFromPBMsgData cNv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity, fm fmVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.cNq = pbActivity;
        this.cNu = fmVar;
        this.bgL = i;
        this.bgM = str;
        this.bgN = j;
        this.cNv = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.cNq.HidenSoftKeyPad((InputMethodManager) this.cNq.getSystemService("input_method"), this.cNu.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.cNq.getPageContext().getPageActivity(), this.bgL, this.bgM, this.bgN, "from_share", this.cNu.getLeaveMsg(), this.cNv.toChatMessageContent())));
        aVar.dismiss();
    }
}
