package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        t tVar;
        if (!StringUtils.isNull(this.this$0.abZ()) && f.acd().ace() != null && f.acd().ace().size() > 0 && (tVar = f.acd().ace().get(0)) != null) {
            if (tVar.customGroupType == 1) {
                MessageUtils.createGroupChatMessage(1, this.this$0.abZ(), com.baidu.adp.lib.g.c.a(tVar.groupId, 0L));
                com.baidu.tbadk.coreExtra.messageCenter.a.rI().dn(tVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(tVar.groupId, 1)));
            } else if (tVar.customGroupType == 2) {
                MessageUtils.createPersonalChatMessage(1, this.this$0.abZ(), com.baidu.adp.lib.g.c.a(tVar.groupId, 0L), tVar.userName, tVar.bML);
                com.baidu.tbadk.coreExtra.messageCenter.a.rI().dn(tVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(tVar.groupId, 2)));
                MessageUtils.sendHasReadMessage(tVar.groupId, 2);
            }
            f.acd().c(tVar);
            this.this$0.aca();
            this.this$0.finish();
        }
    }
}
