package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long blt;
    private final /* synthetic */ String blu;
    private final /* synthetic */ ShareFromGameCenterMsgData cog;
    private final /* synthetic */ com.baidu.tieba.im.widget.b coh;
    final /* synthetic */ SelectFriendActivity cwB;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.cwB = selectFriendActivity;
        this.blt = j;
        this.cog = shareFromGameCenterMsgData;
        this.val$name = str;
        this.blu = str2;
        this.coh = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        long ab = com.baidu.tieba.im.memorycache.b.agR().ab(String.valueOf(this.blt), 2);
        MessageUtils.createPersonalChatMessage(ab, 9, this.cog.toChatMessageContent(), this.blt, this.val$name, this.blu);
        MessageUtils.createPersonalChatMessage(ab + 1, 1, this.coh.getLeaveMsg(), this.blt, this.val$name, this.blu);
        aVar.dismiss();
        this.cwB.setResult(-1);
        if (!i.jf()) {
            this.cwB.showToast(this.cwB.getPageContext().getString(t.j.no_network_guide));
        }
        this.cwB.finish();
    }
}
