package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bHS;
    private final /* synthetic */ String bHT;
    private final /* synthetic */ ShareFromGameCenterMsgData cXo;
    private final /* synthetic */ com.baidu.tieba.im.widget.b cXp;
    final /* synthetic */ SelectFriendActivity dfQ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dfQ = selectFriendActivity;
        this.bHS = j;
        this.cXo = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bHT = str2;
        this.cXp = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        long am = com.baidu.tieba.im.memorycache.b.apZ().am(String.valueOf(this.bHS), 2);
        MessageUtils.createPersonalChatMessage(am, 9, this.cXo.toChatMessageContent(), this.bHS, this.val$name, this.bHT);
        MessageUtils.createPersonalChatMessage(am + 1, 1, this.cXp.getLeaveMsg(), this.bHS, this.val$name, this.bHT);
        aVar.dismiss();
        this.dfQ.setResult(-1);
        if (!i.fq()) {
            this.dfQ.showToast(this.dfQ.getPageContext().getString(u.j.no_network_guide));
        }
        this.dfQ.finish();
    }
}
