package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class g implements a.b {
    private final /* synthetic */ long cgy;
    private final /* synthetic */ String cgz;
    private final /* synthetic */ com.baidu.tieba.im.widget.b deQ;
    final /* synthetic */ SelectFriendActivity dlo;
    private final /* synthetic */ ShareFromPBMsgData dlq;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SelectFriendActivity selectFriendActivity, long j, ShareFromPBMsgData shareFromPBMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dlo = selectFriendActivity;
        this.cgy = j;
        this.dlq = shareFromPBMsgData;
        this.val$name = str;
        this.cgz = str2;
        this.deQ = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ae = com.baidu.tieba.im.memorycache.b.aqX().ae(String.valueOf(this.cgy), 2);
        MessageUtils.createPersonalChatMessage(ae, 9, this.dlq.toChatMessageContent(), this.cgy, this.val$name, this.cgz);
        MessageUtils.createPersonalChatMessage(ae + 1, 1, this.deQ.getLeaveMsg(), this.cgy, this.val$name, this.cgz);
        aVar.dismiss();
        this.dlo.setResult(-1);
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.dlo.showToast(this.dlo.getPageContext().getString(w.l.no_network_guide));
        } else {
            BdToast.b(this.dlo.getPageContext().getPageActivity(), this.dlo.getPageContext().getPageActivity().getString(w.l.share_alert_success), w.g.icon_toast_game_ok).tk();
        }
        this.dlo.finish();
    }
}
