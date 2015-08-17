package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ ShareFromGameCenterMsgData bBX;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bBY;
    final /* synthetic */ SelectFriendActivity bJV;
    private final /* synthetic */ long bJX;
    private final /* synthetic */ String bJY;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bJV = selectFriendActivity;
        this.bJX = j;
        this.bBX = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bJY = str2;
        this.bBY = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long L = com.baidu.tieba.im.memorycache.b.Vl().L(String.valueOf(this.bJX), 2);
        MessageUtils.createPersonalChatMessage(L, 9, this.bBX.toChatMessageContent(), this.bJX, this.val$name, this.bJY);
        MessageUtils.createPersonalChatMessage(L + 1, 1, this.bBY.getLeaveMsg(), this.bJX, this.val$name, this.bJY);
        aVar.dismiss();
        this.bJV.setResult(-1);
        if (!i.iO()) {
            this.bJV.showToast(this.bJV.getPageContext().getString(i.C0057i.no_network_guide));
        }
        this.bJV.finish();
    }
}
