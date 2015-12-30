package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends CustomMessageListener {
    final /* synthetic */ bd cjr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bd bdVar, int i) {
        super(i);
        this.cjr = bdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean jw;
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            jw = this.cjr.jw(intent.getIntExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1));
            if (jw) {
                MentionActivityConfig.newJumpIn = true;
                zVar = this.cjr.cjj;
                if (zVar != null) {
                    zVar2 = this.cjr.cjj;
                    zVar2.onNewIntent(intent);
                }
            }
        }
    }
}
