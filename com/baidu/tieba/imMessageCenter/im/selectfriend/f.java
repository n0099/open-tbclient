package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long cah;
    private final /* synthetic */ String cai;
    private final /* synthetic */ ShareFromGameCenterMsgData dcX;
    private final /* synthetic */ com.baidu.tieba.im.widget.b dcY;
    final /* synthetic */ SelectFriendActivity djy;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.djy = selectFriendActivity;
        this.cah = j;
        this.dcX = shareFromGameCenterMsgData;
        this.val$name = str;
        this.cai = str2;
        this.dcY = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ad = com.baidu.tieba.im.memorycache.b.asc().ad(String.valueOf(this.cah), 2);
        MessageUtils.createPersonalChatMessage(ad, 9, this.dcX.toChatMessageContent(), this.cah, this.val$name, this.cai);
        MessageUtils.createPersonalChatMessage(ad + 1, 1, this.dcY.getLeaveMsg(), this.cah, this.val$name, this.cai);
        aVar.dismiss();
        this.djy.setResult(-1);
        if (!i.hj()) {
            this.djy.showToast(this.djy.getPageContext().getString(w.l.no_network_guide));
        }
        this.djy.finish();
    }
}
