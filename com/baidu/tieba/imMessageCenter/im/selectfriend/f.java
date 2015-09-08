package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ ShareFromGameCenterMsgData bCE;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bCF;
    final /* synthetic */ SelectFriendActivity bKC;
    private final /* synthetic */ long bKE;
    private final /* synthetic */ String bKF;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bKC = selectFriendActivity;
        this.bKE = j;
        this.bCE = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bKF = str2;
        this.bCF = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long M = com.baidu.tieba.im.memorycache.b.Vn().M(String.valueOf(this.bKE), 2);
        MessageUtils.createPersonalChatMessage(M, 9, this.bCE.toChatMessageContent(), this.bKE, this.val$name, this.bKF);
        MessageUtils.createPersonalChatMessage(M + 1, 1, this.bCF.getLeaveMsg(), this.bKE, this.val$name, this.bKF);
        aVar.dismiss();
        this.bKC.setResult(-1);
        if (!i.iL()) {
            this.bKC.showToast(this.bKC.getPageContext().getString(i.h.no_network_guide));
        }
        this.bKC.finish();
    }
}
