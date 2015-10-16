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
    private final /* synthetic */ long aUU;
    private final /* synthetic */ String aUV;
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ cx ciO;
    private final /* synthetic */ ShareFromPBMsgData ciP;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity, cx cxVar, long j, String str, String str2, ShareFromPBMsgData shareFromPBMsgData) {
        this.ciK = pbActivity;
        this.ciO = cxVar;
        this.aUU = j;
        this.val$name = str;
        this.aUV = str2;
        this.ciP = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciK.HidenSoftKeyPad((InputMethodManager) this.ciK.getSystemService("input_method"), this.ciO.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.ciK.getPageContext().getPageActivity(), this.aUU, this.val$name, this.aUV, 0, this.ciO.getLeaveMsg(), this.ciP.toChatMessageContent())));
        aVar.dismiss();
    }
}
