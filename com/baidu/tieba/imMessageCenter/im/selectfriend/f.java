package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ ShareFromGameCenterMsgData bVu;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bVv;
    private final /* synthetic */ long bao;
    private final /* synthetic */ String bap;
    final /* synthetic */ SelectFriendActivity cdx;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.cdx = selectFriendActivity;
        this.bao = j;
        this.bVu = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bap = str2;
        this.bVv = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long T = com.baidu.tieba.im.memorycache.b.Zt().T(String.valueOf(this.bao), 2);
        MessageUtils.createPersonalChatMessage(T, 9, this.bVu.toChatMessageContent(), this.bao, this.val$name, this.bap);
        MessageUtils.createPersonalChatMessage(T + 1, 1, this.bVv.getLeaveMsg(), this.bao, this.val$name, this.bap);
        aVar.dismiss();
        this.cdx.setResult(-1);
        if (!i.iP()) {
            this.cdx.showToast(this.cdx.getPageContext().getString(n.i.no_network_guide));
        }
        this.cdx.finish();
    }
}
