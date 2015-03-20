package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData blp;
    private final /* synthetic */ com.baidu.tieba.im.widget.b blq;
    final /* synthetic */ SelectFriendActivity bte;
    private final /* synthetic */ long btg;
    private final /* synthetic */ String bth;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bte = selectFriendActivity;
        this.btg = j;
        this.blp = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bth = str2;
        this.blq = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long I = com.baidu.tieba.im.memorycache.c.Sd().I(String.valueOf(this.btg), 2);
        MessageUtils.createPersonalChatMessage(I, 9, this.blp.toChatMessageContent(), this.btg, this.val$name, this.bth);
        MessageUtils.createPersonalChatMessage(I + 1, 1, this.blq.getLeaveMsg(), this.btg, this.val$name, this.bth);
        aVar.dismiss();
        this.bte.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bte.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bte.showToast(this.bte.getPageContext().getString(y.no_network_guide));
        }
        this.bte.finish();
    }
}
