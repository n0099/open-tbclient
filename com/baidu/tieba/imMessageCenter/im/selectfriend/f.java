package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bDw;
    private final /* synthetic */ String bDx;
    private final /* synthetic */ ShareFromGameCenterMsgData cUY;
    private final /* synthetic */ com.baidu.tieba.im.widget.b cUZ;
    final /* synthetic */ SelectFriendActivity dbu;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dbu = selectFriendActivity;
        this.bDw = j;
        this.cUY = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bDx = str2;
        this.cUZ = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ak = com.baidu.tieba.im.memorycache.b.arI().ak(String.valueOf(this.bDw), 2);
        MessageUtils.createPersonalChatMessage(ak, 9, this.cUY.toChatMessageContent(), this.bDw, this.val$name, this.bDx);
        MessageUtils.createPersonalChatMessage(ak + 1, 1, this.cUZ.getLeaveMsg(), this.bDw, this.val$name, this.bDx);
        aVar.dismiss();
        this.dbu.setResult(-1);
        if (!i.gm()) {
            this.dbu.showToast(this.dbu.getPageContext().getString(r.j.no_network_guide));
        }
        this.dbu.finish();
    }
}
