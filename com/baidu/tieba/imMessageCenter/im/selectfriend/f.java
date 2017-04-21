package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long ccy;
    private final /* synthetic */ String ccz;
    private final /* synthetic */ ShareFromGameCenterMsgData dfq;
    private final /* synthetic */ com.baidu.tieba.im.widget.b dfr;
    final /* synthetic */ SelectFriendActivity dlP;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dlP = selectFriendActivity;
        this.ccy = j;
        this.dfq = shareFromGameCenterMsgData;
        this.val$name = str;
        this.ccz = str2;
        this.dfr = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ad = com.baidu.tieba.im.memorycache.b.atd().ad(String.valueOf(this.ccy), 2);
        MessageUtils.createPersonalChatMessage(ad, 9, this.dfq.toChatMessageContent(), this.ccy, this.val$name, this.ccz);
        MessageUtils.createPersonalChatMessage(ad + 1, 1, this.dfr.getLeaveMsg(), this.ccy, this.val$name, this.ccz);
        aVar.dismiss();
        this.dlP.setResult(-1);
        if (!i.hk()) {
            this.dlP.showToast(this.dlP.getPageContext().getString(w.l.no_network_guide));
        }
        this.dlP.finish();
    }
}
