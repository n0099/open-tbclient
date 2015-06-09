package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ ShareFromGameCenterMsgData bok;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bol;
    final /* synthetic */ SelectFriendActivity bwf;
    private final /* synthetic */ long bwh;
    private final /* synthetic */ String bwi;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bwf = selectFriendActivity;
        this.bwh = j;
        this.bok = shareFromGameCenterMsgData;
        this.val$name = str;
        this.bwi = str2;
        this.bol = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long I = com.baidu.tieba.im.memorycache.c.TE().I(String.valueOf(this.bwh), 2);
        MessageUtils.createPersonalChatMessage(I, 9, this.bok.toChatMessageContent(), this.bwh, this.val$name, this.bwi);
        MessageUtils.createPersonalChatMessage(I + 1, 1, this.bol.getLeaveMsg(), this.bwh, this.val$name, this.bwi);
        aVar.dismiss();
        this.bwf.setResult(-1);
        if (UtilHelper.getNetStatusInfo(this.bwf.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.bwf.showToast(this.bwf.getPageContext().getString(t.no_network_guide));
        }
        this.bwf.finish();
    }
}
