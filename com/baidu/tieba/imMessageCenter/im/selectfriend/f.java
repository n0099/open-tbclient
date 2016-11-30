package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bXm;
    private final /* synthetic */ String bXn;
    private final /* synthetic */ ShareFromGameCenterMsgData dqe;
    private final /* synthetic */ com.baidu.tieba.im.widget.b dqf;
    final /* synthetic */ SelectFriendActivity dyz;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.dyz = selectFriendActivity;
        this.bXm = j;
        this.dqe = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bXn = str2;
        this.dqf = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long am = com.baidu.tieba.im.memorycache.b.axj().am(String.valueOf(this.bXm), 2);
        MessageUtils.createPersonalChatMessage(am, 9, this.dqe.toChatMessageContent(), this.bXm, this.val$name, this.bXn);
        MessageUtils.createPersonalChatMessage(am + 1, 1, this.dqf.getLeaveMsg(), this.bXm, this.val$name, this.bXn);
        aVar.dismiss();
        this.dyz.setResult(-1);
        if (!i.gm()) {
            this.dyz.showToast(this.dyz.getPageContext().getString(r.j.no_network_guide));
        }
        this.dyz.finish();
    }
}
