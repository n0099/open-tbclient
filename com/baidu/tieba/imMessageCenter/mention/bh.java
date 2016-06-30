package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends CustomMessageListener {
    final /* synthetic */ bf deP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bf bfVar, int i) {
        super(i);
        this.deP = bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean lG;
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            lG = this.deP.lG(intent.getIntExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1));
            if (lG) {
                MentionActivityConfig.newJumpIn = true;
                zVar = this.deP.deH;
                if (zVar != null) {
                    zVar2 = this.deP.deH;
                    zVar2.onNewIntent(intent);
                }
            }
        }
    }
}
