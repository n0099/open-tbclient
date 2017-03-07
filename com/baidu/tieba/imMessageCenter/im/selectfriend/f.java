package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long cbG;
    private final /* synthetic */ String cbH;
    private final /* synthetic */ ShareFromGameCenterMsgData deC;
    private final /* synthetic */ com.baidu.tieba.im.widget.b deD;
    final /* synthetic */ SelectFriendActivity dkZ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dkZ = selectFriendActivity;
        this.cbG = j;
        this.deC = shareFromGameCenterMsgData;
        this.val$name = str;
        this.cbH = str2;
        this.deD = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ad = com.baidu.tieba.im.memorycache.b.asj().ad(String.valueOf(this.cbG), 2);
        MessageUtils.createPersonalChatMessage(ad, 9, this.deC.toChatMessageContent(), this.cbG, this.val$name, this.cbH);
        MessageUtils.createPersonalChatMessage(ad + 1, 1, this.deD.getLeaveMsg(), this.cbG, this.val$name, this.cbH);
        aVar.dismiss();
        this.dkZ.setResult(-1);
        if (!i.he()) {
            this.dkZ.showToast(this.dkZ.getPageContext().getString(w.l.no_network_guide));
        }
        this.dkZ.finish();
    }
}
