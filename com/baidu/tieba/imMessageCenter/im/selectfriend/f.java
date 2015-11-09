package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long aVc;
    private final /* synthetic */ String aVd;
    private final /* synthetic */ ShareFromGameCenterMsgData bGn;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bGo;
    final /* synthetic */ SelectFriendActivity bOu;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bOu = selectFriendActivity;
        this.aVc = j;
        this.bGn = shareFromGameCenterMsgData;
        this.val$name = str;
        this.aVd = str2;
        this.bGo = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long O = com.baidu.tieba.im.memorycache.b.Wn().O(String.valueOf(this.aVc), 2);
        MessageUtils.createPersonalChatMessage(O, 9, this.bGn.toChatMessageContent(), this.aVc, this.val$name, this.aVd);
        MessageUtils.createPersonalChatMessage(O + 1, 1, this.bGo.getLeaveMsg(), this.aVc, this.val$name, this.aVd);
        aVar.dismiss();
        this.bOu.setResult(-1);
        if (!i.iN()) {
            this.bOu.showToast(this.bOu.getPageContext().getString(i.h.no_network_guide));
        }
        this.bOu.finish();
    }
}
