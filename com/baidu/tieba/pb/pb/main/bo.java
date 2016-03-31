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
public class bo implements a.b {
    private final /* synthetic */ int blw;
    private final /* synthetic */ String blx;
    private final /* synthetic */ long bly;
    private final /* synthetic */ gn dhA;
    private final /* synthetic */ ShareFromPBMsgData dhB;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity, gn gnVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.dht = pbActivity;
        this.dhA = gnVar;
        this.blw = i;
        this.blx = str;
        this.bly = j;
        this.dhB = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int awo;
        this.dht.HidenSoftKeyPad((InputMethodManager) this.dht.getSystemService("input_method"), this.dhA.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.dht.getPageContext().getPageActivity(), this.blw, this.blx, this.bly, "from_share", this.dhA.getLeaveMsg(), this.dhB.toChatMessageContent())));
        aVar.dismiss();
        awo = this.dht.awo();
        if (awo == 1) {
            this.dht.aws();
        }
    }
}
