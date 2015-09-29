package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long aUJ;
    private final /* synthetic */ String aUK;
    private final /* synthetic */ ShareFromGameCenterMsgData bFH;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bFI;
    final /* synthetic */ SelectFriendActivity bNO;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bNO = selectFriendActivity;
        this.aUJ = j;
        this.bFH = shareFromGameCenterMsgData;
        this.val$name = str;
        this.aUK = str2;
        this.bFI = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long O = com.baidu.tieba.im.memorycache.b.VW().O(String.valueOf(this.aUJ), 2);
        MessageUtils.createPersonalChatMessage(O, 9, this.bFH.toChatMessageContent(), this.aUJ, this.val$name, this.aUK);
        MessageUtils.createPersonalChatMessage(O + 1, 1, this.bFI.getLeaveMsg(), this.aUJ, this.val$name, this.aUK);
        aVar.dismiss();
        this.bNO.setResult(-1);
        if (!i.iM()) {
            this.bNO.showToast(this.bNO.getPageContext().getString(i.h.no_network_guide));
        }
        this.bNO.finish();
    }
}
