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
public class ab implements a.b {
    private final /* synthetic */ long aUJ;
    private final /* synthetic */ String aUK;
    private final /* synthetic */ cx ciD;
    private final /* synthetic */ ShareFromPBMsgData ciE;
    final /* synthetic */ PbActivity ciz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity, cx cxVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ciz = pbActivity;
        this.ciD = cxVar;
        this.aUJ = j;
        this.val$name = str;
        this.aUK = str2;
        this.ciE = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciz.HidenSoftKeyPad((InputMethodManager) this.ciz.getSystemService("input_method"), this.ciD.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ciz.getPageContext().getPageActivity(), this.aUJ, this.val$name, this.aUK, 0, this.ciD.getLeaveMsg(), this.ciE.toChatMessageContent())));
        aVar.dismiss();
    }
}
