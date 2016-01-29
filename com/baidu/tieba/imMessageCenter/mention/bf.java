package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends CustomMessageListener {
    final /* synthetic */ bd cnR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bd bdVar, int i) {
        super(i);
        this.cnR = bdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean jT;
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            jT = this.cnR.jT(intent.getIntExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1));
            if (jT) {
                MentionActivityConfig.newJumpIn = true;
                zVar = this.cnR.cnJ;
                if (zVar != null) {
                    zVar2 = this.cnR.cnJ;
                    zVar2.onNewIntent(intent);
                }
            }
        }
    }
}
