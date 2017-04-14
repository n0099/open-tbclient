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
public class bh implements a.b {
    private final /* synthetic */ int cak;
    private final /* synthetic */ String cal;
    private final /* synthetic */ long cam;
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ gq ekd;
    private final /* synthetic */ ShareFromPBMsgData eke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, gq gqVar, int i, String str, long j, ShareFromPBMsgData shareFromPBMsgData) {
        this.ejU = pbActivity;
        this.ekd = gqVar;
        this.cak = i;
        this.cal = str;
        this.cam = j;
        this.eke = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        int aKw;
        this.ejU.HidenSoftKeyPad((InputMethodManager) this.ejU.getSystemService("input_method"), this.ekd.getChatMsgView());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(this.ejU.getPageContext().getPageActivity(), this.cak, this.cal, this.cam, "from_share", this.ekd.getLeaveMsg(), this.eke.toChatMessageContent())));
        aVar.dismiss();
        aKw = this.ejU.aKw();
        if (aKw == 1) {
            this.ejU.aKB();
        }
    }
}
