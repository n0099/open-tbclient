package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ i fge;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(i iVar, int i) {
        super(i);
        this.fge = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && com.baidu.tbadk.coreExtra.messageCenter.c.zG().zZ() && i.baW()) {
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours < 0 || hours > 7) && hours < 23) {
                RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                if (!this.fge.ffV.isScreenOn()) {
                    this.fge.a(remindRecommendMessage);
                } else {
                    this.fge.b(remindRecommendMessage);
                }
                if (remindRecommendMessage.isLocal) {
                    TiebaStatic.log(new as("c10316").s("obj_type", 2).s("obj_locate", 1));
                } else {
                    TiebaStatic.log(new as("c10316").s("obj_type", 1).s("obj_locate", 1));
                }
            }
        }
    }
}
