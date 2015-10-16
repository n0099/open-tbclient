package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.i;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ long aUU;
    private final /* synthetic */ String aUV;
    private final /* synthetic */ ShareFromGameCenterMsgData bFS;
    private final /* synthetic */ com.baidu.tieba.im.widget.b bFT;
    final /* synthetic */ SelectFriendActivity bNZ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, com.baidu.tieba.im.widget.b bVar) {
        this.bNZ = selectFriendActivity;
        this.aUU = j;
        this.bFS = shareFromGameCenterMsgData;
        this.val$name = str;
        this.aUV = str2;
        this.bFT = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long O = com.baidu.tieba.im.memorycache.b.VW().O(String.valueOf(this.aUU), 2);
        MessageUtils.createPersonalChatMessage(O, 9, this.bFS.toChatMessageContent(), this.aUU, this.val$name, this.aUV);
        MessageUtils.createPersonalChatMessage(O + 1, 1, this.bFT.getLeaveMsg(), this.aUU, this.val$name, this.aUV);
        aVar.dismiss();
        this.bNZ.setResult(-1);
        if (!i.iM()) {
            this.bNZ.showToast(this.bNZ.getPageContext().getString(i.h.no_network_guide));
        }
        this.bNZ.finish();
    }
}
