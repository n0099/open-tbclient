package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
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
        if (!StringUtils.isNull(this.this$0.aMD()) && f.aMF().aMH() != null && f.aMF().aMH().size() > 0 && (pVar = f.aMF().aMH().get(0)) != null) {
            if (pVar.customGroupType == 1) {
                MessageUtils.createGroupChatMessage(1, this.this$0.aMD(), com.baidu.adp.lib.h.b.c(pVar.groupId, 0L));
                com.baidu.tbadk.coreExtra.messageCenter.a.zp().eo(pVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(pVar.groupId, 1)));
            } else if (pVar.customGroupType == 2) {
                MessageUtils.createPersonalChatMessage(1, this.this$0.aMD(), com.baidu.adp.lib.h.b.c(pVar.groupId, 0L), pVar.userName, pVar.eaj);
                com.baidu.tbadk.coreExtra.messageCenter.a.zp().eo(pVar.groupId);
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(pVar.groupId, 2)));
                MessageUtils.sendHasReadMessage(pVar.groupId, 2);
            }
            new aq("lockscreen_reply", true).start();
            f.aMF().c(pVar);
            f.aMF().dZK.aMN();
            this.this$0.finish();
        }
    }
}
