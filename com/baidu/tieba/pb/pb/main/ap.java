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
public class ap implements a.b {
    private final /* synthetic */ long bgI;
    private final /* synthetic */ String bgJ;
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ fm cNu;
    private final /* synthetic */ ShareFromPBMsgData cNv;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity, fm fmVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.cNq = pbActivity;
        this.cNu = fmVar;
        this.bgI = j;
        this.val$name = str;
        this.bgJ = str2;
        this.cNv = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.cNq.HidenSoftKeyPad((InputMethodManager) this.cNq.getSystemService("input_method"), this.cNu.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.cNq.getPageContext().getPageActivity(), this.bgI, this.val$name, this.bgJ, 0, this.cNu.getLeaveMsg(), this.cNv.toChatMessageContent())));
        aVar.dismiss();
    }
}
