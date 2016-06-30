package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ f eHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(f fVar, int i) {
        super(i);
        this.eHG = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && com.baidu.tbadk.coreExtra.messageCenter.c.xK().ye() && f.aUY()) {
            int hours = new Date(System.currentTimeMillis()).getHours();
            if ((hours < 0 || hours > 7) && hours < 23) {
                RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                if (!this.eHG.eHx.isScreenOn()) {
                    this.eHG.a(remindRecommendMessage);
                } else {
                    this.eHG.b(remindRecommendMessage);
                }
                if (remindRecommendMessage.isLocal) {
                    TiebaStatic.log(new ay("c10316").s("obj_type", 2).s("obj_locate", 1));
                } else {
                    TiebaStatic.log(new ay("c10316").s("obj_type", 1).s("obj_locate", 1));
                }
            }
        }
    }
}
