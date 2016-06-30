package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bGw;
    private final /* synthetic */ String bGx;
    private final /* synthetic */ ShareFromGameCenterMsgData cUt;
    private final /* synthetic */ com.baidu.tieba.im.widget.b cUu;
    final /* synthetic */ SelectFriendActivity dcT;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dcT = selectFriendActivity;
        this.bGw = j;
        this.cUt = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bGx = str2;
        this.cUu = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        long am = com.baidu.tieba.im.memorycache.b.apn().am(String.valueOf(this.bGw), 2);
        MessageUtils.createPersonalChatMessage(am, 9, this.cUt.toChatMessageContent(), this.bGw, this.val$name, this.bGx);
        MessageUtils.createPersonalChatMessage(am + 1, 1, this.cUu.getLeaveMsg(), this.bGw, this.val$name, this.bGx);
        aVar.dismiss();
        this.dcT.setResult(-1);
        if (!i.fr()) {
            this.dcT.showToast(this.dcT.getPageContext().getString(u.j.no_network_guide));
        }
        this.dcT.finish();
    }
}
