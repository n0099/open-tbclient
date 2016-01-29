package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bgI;
    private final /* synthetic */ String bgJ;
    private final /* synthetic */ ShareFromGameCenterMsgData cdB;
    private final /* synthetic */ com.baidu.tieba.im.widget.b cdC;
    final /* synthetic */ SelectFriendActivity clY;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.clY = selectFriendActivity;
        this.bgI = j;
        this.cdB = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bgJ = str2;
        this.cdC = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        long U = com.baidu.tieba.im.memorycache.b.ady().U(String.valueOf(this.bgI), 2);
        MessageUtils.createPersonalChatMessage(U, 9, this.cdB.toChatMessageContent(), this.bgI, this.val$name, this.bgJ);
        MessageUtils.createPersonalChatMessage(U + 1, 1, this.cdC.getLeaveMsg(), this.bgI, this.val$name, this.bgJ);
        aVar.dismiss();
        this.clY.setResult(-1);
        if (!i.iZ()) {
            this.clY.showToast(this.clY.getPageContext().getString(t.j.no_network_guide));
        }
        this.clY.finish();
    }
}
