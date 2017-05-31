package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class i implements a.b {
    private final /* synthetic */ long cgy;
    private final /* synthetic */ String cgz;
    private final /* synthetic */ ShareFromGameCenterMsgData deP;
    private final /* synthetic */ com.baidu.tieba.im.widget.b deQ;
    final /* synthetic */ SelectFriendActivity dlo;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dlo = selectFriendActivity;
        this.cgy = j;
        this.deP = shareFromGameCenterMsgData;
        this.val$name = str;
        this.cgz = str2;
        this.deQ = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ae = com.baidu.tieba.im.memorycache.b.aqX().ae(String.valueOf(this.cgy), 2);
        MessageUtils.createPersonalChatMessage(ae, 9, this.deP.toChatMessageContent(), this.cgy, this.val$name, this.cgz);
        MessageUtils.createPersonalChatMessage(ae + 1, 1, this.deQ.getLeaveMsg(), this.cgy, this.val$name, this.cgz);
        aVar.dismiss();
        this.dlo.setResult(-1);
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.dlo.showToast(this.dlo.getPageContext().getString(w.l.no_network_guide));
        }
        this.dlo.finish();
    }
}
