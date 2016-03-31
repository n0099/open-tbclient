package com.baidu.tieba.pb.pb.main;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements a.b {
    private final /* synthetic */ long blt;
    private final /* synthetic */ String blu;
    private final /* synthetic */ gn dhA;
    private final /* synthetic */ ShareFromPBMsgData dhB;
    final /* synthetic */ PbActivity dht;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity, gn gnVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.dht = pbActivity;
        this.dhA = gnVar;
        this.blt = j;
        this.val$name = str;
        this.blu = str2;
        this.dhB = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        int awo;
        this.dht.HidenSoftKeyPad((InputMethodManager) this.dht.getSystemService("input_method"), this.dhA.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.dht.getPageContext().getPageActivity(), this.blt, this.val$name, this.blu, 0, this.dhA.getLeaveMsg(), this.dhB.toChatMessageContent())));
        aVar.dismiss();
        awo = this.dht.awo();
        if (awo == 1) {
            this.dht.aws();
        }
    }
}
