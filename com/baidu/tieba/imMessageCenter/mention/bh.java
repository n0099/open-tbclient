package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends CustomMessageListener {
    final /* synthetic */ bf dts;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bf bfVar, int i) {
        super(i);
        this.dts = bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean mp;
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            mp = this.dts.mp(intent.getIntExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1));
            if (mp) {
                MentionActivityConfig.newJumpIn = true;
                zVar = this.dts.dtk;
                if (zVar != null) {
                    zVar2 = this.dts.dtk;
                    zVar2.onNewIntent(intent);
                }
            }
        }
    }
}
