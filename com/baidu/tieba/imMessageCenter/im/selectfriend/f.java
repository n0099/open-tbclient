package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bhx;
    private final /* synthetic */ String bhy;
    private final /* synthetic */ ShareFromGameCenterMsgData cpd;
    private final /* synthetic */ com.baidu.tieba.im.widget.b cpe;
    final /* synthetic */ SelectFriendActivity cxy;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.cxy = selectFriendActivity;
        this.bhx = j;
        this.cpd = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bhy = str2;
        this.cpe = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        long af = com.baidu.tieba.im.memorycache.b.agY().af(String.valueOf(this.bhx), 2);
        MessageUtils.createPersonalChatMessage(af, 9, this.cpd.toChatMessageContent(), this.bhx, this.val$name, this.bhy);
        MessageUtils.createPersonalChatMessage(af + 1, 1, this.cpe.getLeaveMsg(), this.bhx, this.val$name, this.bhy);
        aVar.dismiss();
        this.cxy.setResult(-1);
        if (!i.fq()) {
            this.cxy.showToast(this.cxy.getPageContext().getString(t.j.no_network_guide));
        }
        this.cxy.finish();
    }
}
