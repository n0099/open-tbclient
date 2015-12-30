package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ ShareFromGameCenterMsgData bZg;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bZh;
    private final /* synthetic */ long ben;
    private final /* synthetic */ String beo;
    final /* synthetic */ SelectFriendActivity chx;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.chx = selectFriendActivity;
        this.ben = j;
        this.bZg = shareFromGameCenterMsgData;
        this.val$name = str;
        this.beo = str2;
        this.bZh = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long T = com.baidu.tieba.im.memorycache.b.aay().T(String.valueOf(this.ben), 2);
        MessageUtils.createPersonalChatMessage(T, 9, this.bZg.toChatMessageContent(), this.ben, this.val$name, this.beo);
        MessageUtils.createPersonalChatMessage(T + 1, 1, this.bZh.getLeaveMsg(), this.ben, this.val$name, this.beo);
        aVar.dismiss();
        this.chx.setResult(-1);
        if (!i.iQ()) {
            this.chx.showToast(this.chx.getPageContext().getString(n.j.no_network_guide));
        }
        this.chx.finish();
    }
}
