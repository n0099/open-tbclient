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
        if (!StringUtils.isNull(this.this$0.acy()) && f.acB().acC() != null && f.acB().acC().size() > 0 && (tVar = f.acB().acC().get(0)) != null) {
            if (tVar.customGroupType == 1) {
                MessageUtils.createGroupChatMessage(1, this.this$0.acy(), com.baidu.adp.lib.g.c.a(tVar.groupId, 0L));
                com.baidu.tbadk.coreExtra.messageCenter.a.rS().dj(tVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(tVar.groupId, 1)));
            } else if (tVar.customGroupType == 2) {
                MessageUtils.createPersonalChatMessage(1, this.this$0.acy(), com.baidu.adp.lib.g.c.a(tVar.groupId, 0L), tVar.userName, tVar.bOu);
                com.baidu.tbadk.coreExtra.messageCenter.a.rS().dj(tVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a(tVar.groupId, 2)));
                MessageUtils.sendHasReadMessage(tVar.groupId, 2);
            }
            f.acB().c(tVar);
            f.acB().bOb.acH();
            this.this$0.finish();
        }
    }
}
