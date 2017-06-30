package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class i implements a.b {
    private final /* synthetic */ long coO;
    private final /* synthetic */ String coP;
    private final /* synthetic */ ShareFromGameCenterMsgData dmK;
    private final /* synthetic */ com.baidu.tieba.im.widget.b dmL;
    final /* synthetic */ SelectFriendActivity dtk;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dtk = selectFriendActivity;
        this.coO = j;
        this.dmK = shareFromGameCenterMsgData;
        this.val$name = str;
        this.coP = str2;
        this.dmL = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ag = com.baidu.tieba.im.memorycache.b.auI().ag(String.valueOf(this.coO), 2);
        MessageUtils.createPersonalChatMessage(ag, 9, this.dmK.toChatMessageContent(), this.coO, this.val$name, this.coP);
        MessageUtils.createPersonalChatMessage(ag + 1, 1, this.dmL.getLeaveMsg(), this.coO, this.val$name, this.coP);
        aVar.dismiss();
        this.dtk.setResult(-1);
        if (!com.baidu.adp.lib.util.i.hj()) {
            this.dtk.showToast(this.dtk.getPageContext().getString(w.l.no_network_guide));
        }
        this.dtk.finish();
    }
}
