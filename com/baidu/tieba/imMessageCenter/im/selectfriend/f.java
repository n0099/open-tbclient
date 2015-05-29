package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData boj;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bok;
    final /* synthetic */ SelectFriendActivity bwe;
    private final /* synthetic */ long bwg;
    private final /* synthetic */ String bwh;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bwe = selectFriendActivity;
        this.bwg = j;
        this.boj = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bwh = str2;
        this.bok = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long I = com.baidu.tieba.im.memorycache.c.TD().I(String.valueOf(this.bwg), 2);
        MessageUtils.createPersonalChatMessage(I, 9, this.boj.toChatMessageContent(), this.bwg, this.val$name, this.bwh);
        MessageUtils.createPersonalChatMessage(I + 1, 1, this.bok.getLeaveMsg(), this.bwg, this.val$name, this.bwh);
        aVar.dismiss();
        this.bwe.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bwe.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bwe.showToast(this.bwe.getPageContext().getString(t.no_network_guide));
        }
        this.bwe.finish();
    }
}
