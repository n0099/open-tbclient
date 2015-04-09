package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData blF;
    private final /* synthetic */ com.baidu.tieba.im.widget.b blG;
    final /* synthetic */ SelectFriendActivity btv;
    private final /* synthetic */ long btx;
    private final /* synthetic */ String bty;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.btv = selectFriendActivity;
        this.btx = j;
        this.blF = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bty = str2;
        this.blG = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long I = com.baidu.tieba.im.memorycache.c.Sq().I(String.valueOf(this.btx), 2);
        MessageUtils.createPersonalChatMessage(I, 9, this.blF.toChatMessageContent(), this.btx, this.val$name, this.bty);
        MessageUtils.createPersonalChatMessage(I + 1, 1, this.blG.getLeaveMsg(), this.btx, this.val$name, this.bty);
        aVar.dismiss();
        this.btv.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.btv.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.btv.showToast(this.btv.getPageContext().getString(y.no_network_guide));
        }
        this.btv.finish();
    }
}
