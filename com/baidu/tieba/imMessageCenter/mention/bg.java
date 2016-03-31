package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ be cyt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(be beVar, int i) {
        super(i);
        this.cyt = beVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean kz;
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            kz = this.cyt.kz(intent.getIntExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1));
            if (kz) {
                MentionActivityConfig.newJumpIn = true;
                zVar = this.cyt.cyl;
                if (zVar != null) {
                    zVar2 = this.cyt.cyl;
                    zVar2.onNewIntent(intent);
                }
            }
        }
    }
}
