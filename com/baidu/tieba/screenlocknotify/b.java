package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.util.MessageUtils;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.screenlocknotify.a.a aVar;
        com.baidu.tieba.screenlocknotify.a.a aVar2;
        com.baidu.tieba.screenlocknotify.a.a aVar3;
        com.baidu.tieba.screenlocknotify.a.a aVar4;
        com.baidu.tieba.screenlocknotify.a.a aVar5;
        aVar = this.this$0.eZQ;
        if (aVar != null) {
            aVar2 = this.this$0.eZQ;
            if (!StringUtils.isNull(aVar2.getInputMsg())) {
                aVar3 = this.this$0.eZQ;
                s data = aVar3.getData();
                if (data != null) {
                    if (data.customGroupType == 4) {
                        TiebaStatic.log(new ar("c11703").g(PbActivityConfig.KEY_MSG_ID, data.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, data.taskId));
                    }
                    if (data.customGroupType == 1) {
                        long c = com.baidu.adp.lib.g.b.c(data.groupId, 0L);
                        aVar5 = this.this$0.eZQ;
                        MessageUtils.createGroupChatMessage(1, aVar5.getInputMsg(), c);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yt().er(data.groupId);
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 1)));
                    } else if (data.customGroupType == 2) {
                        long c2 = com.baidu.adp.lib.g.b.c(data.groupId, 0L);
                        aVar4 = this.this$0.eZQ;
                        MessageUtils.createPersonalChatMessage(1, aVar4.getInputMsg(), c2, data.userName, data.far);
                        com.baidu.tbadk.coreExtra.messageCenter.a.yt().er(data.groupId);
                        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.groupId, 2)));
                        MessageUtils.sendHasReadMessage(data.groupId, 2);
                    }
                    new am("lockscreen_reply", true).start();
                    i.baB().eZY.baG();
                    this.this$0.finish();
                }
            }
        }
    }
}
