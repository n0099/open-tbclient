package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long bUu;
    private final /* synthetic */ String bUv;
    private final /* synthetic */ ShareFromGameCenterMsgData dci;
    private final /* synthetic */ com.baidu.tieba.im.widget.b dcj;
    final /* synthetic */ SelectFriendActivity diG;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.diG = selectFriendActivity;
        this.bUu = j;
        this.dci = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bUv = str2;
        this.dcj = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long ak = com.baidu.tieba.im.memorycache.b.asO().ak(String.valueOf(this.bUu), 2);
        MessageUtils.createPersonalChatMessage(ak, 9, this.dci.toChatMessageContent(), this.bUu, this.val$name, this.bUv);
        MessageUtils.createPersonalChatMessage(ak + 1, 1, this.dcj.getLeaveMsg(), this.bUu, this.val$name, this.bUv);
        aVar.dismiss();
        this.diG.setResult(-1);
        if (!i.gk()) {
            this.diG.showToast(this.diG.getPageContext().getString(r.l.no_network_guide));
        }
        this.diG.finish();
    }
}
