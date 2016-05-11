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
public class ba implements a.b {
    private final /* synthetic */ int bhA;
    private final /* synthetic */ String bhB;
    private final /* synthetic */ long bhC;
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ ga djJ;
    private final /* synthetic */ ShareFromPBMsgData djK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity, ga gaVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.djE = pbActivity;
        this.djJ = gaVar;
        this.bhA = i;
        this.bhB = str;
        this.bhC = j;
        this.djK = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int awy;
        this.djE.HidenSoftKeyPad((InputMethodManager) this.djE.getSystemService("input_method"), this.djJ.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.djE.getPageContext().getPageActivity(), this.bhA, this.bhB, this.bhC, "from_share", this.djJ.getLeaveMsg(), this.djK.toChatMessageContent())));
        aVar.dismiss();
        awy = this.djE.awy();
        if (awy == 1) {
            this.djE.awC();
        }
    }
}
