package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class f implements a.b {
    private final /* synthetic */ ShareFromGameCenterMsgData cZp;
    private final /* synthetic */ com.baidu.tieba.im.widget.b cZq;
    private final /* synthetic */ long cam;
    private final /* synthetic */ String can;
    final /* synthetic */ SelectFriendActivity dfT;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dfT = selectFriendActivity;
        this.cam = j;
        this.cZp = shareFromGameCenterMsgData;
        this.val$name = str;
        this.can = str2;
        this.cZq = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ae = com.baidu.tieba.im.memorycache.b.apX().ae(String.valueOf(this.cam), 2);
        MessageUtils.createPersonalChatMessage(ae, 9, this.cZp.toChatMessageContent(), this.cam, this.val$name, this.can);
        MessageUtils.createPersonalChatMessage(ae + 1, 1, this.cZq.getLeaveMsg(), this.cam, this.val$name, this.can);
        aVar.dismiss();
        this.dfT.setResult(-1);
        if (!i.hk()) {
            this.dfT.showToast(this.dfT.getPageContext().getString(w.l.no_network_guide));
        }
        this.dfT.finish();
    }
}
