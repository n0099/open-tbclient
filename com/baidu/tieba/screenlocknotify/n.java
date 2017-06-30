package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ i fwx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(i iVar, int i) {
        super(i);
        this.fwx = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && com.baidu.tbadk.coreExtra.messageCenter.c.zd().zw() && i.bff()) {
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours < 0 || hours > 7) && hours < 23) {
                RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                if (!this.fwx.fwo.isScreenOn()) {
                    this.fwx.a(remindRecommendMessage);
                } else {
                    this.fwx.b(remindRecommendMessage);
                }
                if (remindRecommendMessage.isLocal) {
                    TiebaStatic.log(new au("c10316").r("obj_type", 2).r("obj_locate", 1));
                } else {
                    TiebaStatic.log(new au("c10316").r("obj_type", 1).r("obj_locate", 1));
                }
            }
        }
    }
}
