package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bSR;
    private final /* synthetic */ String bSS;
    private final /* synthetic */ ShareFromGameCenterMsgData dku;
    private final /* synthetic */ com.baidu.tieba.im.widget.b dkv;
    final /* synthetic */ SelectFriendActivity dsU;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dsU = selectFriendActivity;
        this.bSR = j;
        this.dku = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bSS = str2;
        this.dkv = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long am = com.baidu.tieba.im.memorycache.b.avm().am(String.valueOf(this.bSR), 2);
        MessageUtils.createPersonalChatMessage(am, 9, this.dku.toChatMessageContent(), this.bSR, this.val$name, this.bSS);
        MessageUtils.createPersonalChatMessage(am + 1, 1, this.dkv.getLeaveMsg(), this.bSR, this.val$name, this.bSS);
        aVar.dismiss();
        this.dsU.setResult(-1);
        if (!i.gm()) {
            this.dsU.showToast(this.dsU.getPageContext().getString(r.j.no_network_guide));
        }
        this.dsU.finish();
    }
}
