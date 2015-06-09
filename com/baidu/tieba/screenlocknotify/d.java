package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aw;
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
        r rVar;
        if (!StringUtils.isNull(this.this$0.ahN()) && f.ahQ().ahR() != null && f.ahQ().ahR().size() > 0 && (rVar = f.ahQ().ahR().get(0)) != null) {
            if (rVar.customGroupType == 1) {
                MessageUtils.createGroupChatMessage(1, this.this$0.ahN(), com.baidu.adp.lib.g.c.c(rVar.groupId, 0L));
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().dK(rVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(rVar.groupId, 1)));
            } else if (rVar.customGroupType == 2) {
                MessageUtils.createPersonalChatMessage(1, this.this$0.ahN(), com.baidu.adp.lib.g.c.c(rVar.groupId, 0L), rVar.userName, rVar.cds);
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().dK(rVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(rVar.groupId, 2)));
                MessageUtils.sendHasReadMessage(rVar.groupId, 2);
            }
            new aw("lockscreen_reply", true).start();
            f.ahQ().c(rVar);
            f.ahQ().ccY.ahW();
            this.this$0.finish();
        }
    }
}
