package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bSY;
    private final /* synthetic */ String bSZ;
    private final /* synthetic */ ShareFromGameCenterMsgData diX;
    private final /* synthetic */ com.baidu.tieba.im.widget.b diY;
    final /* synthetic */ SelectFriendActivity drx;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.drx = selectFriendActivity;
        this.bSY = j;
        this.diX = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bSZ = str2;
        this.diY = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long am = com.baidu.tieba.im.memorycache.b.auN().am(String.valueOf(this.bSY), 2);
        MessageUtils.createPersonalChatMessage(am, 9, this.diX.toChatMessageContent(), this.bSY, this.val$name, this.bSZ);
        MessageUtils.createPersonalChatMessage(am + 1, 1, this.diY.getLeaveMsg(), this.bSY, this.val$name, this.bSZ);
        aVar.dismiss();
        this.drx.setResult(-1);
        if (!i.gm()) {
            this.drx.showToast(this.drx.getPageContext().getString(t.j.no_network_guide));
        }
        this.drx.finish();
    }
}
