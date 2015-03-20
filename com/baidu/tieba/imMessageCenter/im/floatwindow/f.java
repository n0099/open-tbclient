package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ b bqs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar) {
        super(2001011);
        this.bqs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Boolean data;
        if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
            TbadkCoreApplication.m411getInst().setProcesBackground(data.booleanValue());
            if (data.booleanValue()) {
                this.bqs.isBackground = true;
                this.bqs.dk(false);
                return;
            }
            this.bqs.isBackground = false;
            this.bqs.dj(true);
        }
    }
}
