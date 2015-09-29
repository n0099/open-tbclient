package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
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
        p pVar;
        if (!StringUtils.isNull(this.this$0.aqy()) && f.aqB().aqD() != null && f.aqB().aqD().size() > 0 && (pVar = f.aqB().aqD().get(0)) != null) {
            if (pVar.customGroupType == 1) {
                MessageUtils.createGroupChatMessage(1, this.this$0.aqy(), com.baidu.adp.lib.g.b.c(pVar.groupId, 0L));
                com.baidu.tbadk.coreExtra.messageCenter.a.wK().dX(pVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(pVar.groupId, 1)));
            } else if (pVar.customGroupType == 2) {
                MessageUtils.createPersonalChatMessage(1, this.this$0.aqy(), com.baidu.adp.lib.g.b.c(pVar.groupId, 0L), pVar.userName, pVar.cKs);
                com.baidu.tbadk.coreExtra.messageCenter.a.wK().dX(pVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(pVar.groupId, 2)));
                MessageUtils.sendHasReadMessage(pVar.groupId, 2);
            }
            new ak("lockscreen_reply", true).start();
            f.aqB().c(pVar);
            f.aqB().cJS.aqJ();
            this.this$0.finish();
        }
    }
}
