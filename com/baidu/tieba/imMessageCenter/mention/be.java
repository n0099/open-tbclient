package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends CustomMessageListener {
    final /* synthetic */ bc cfn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.cfn = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean iX;
        y yVar;
        y yVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
            Intent intent = (Intent) customResponsedMessage.getData();
            iX = this.cfn.iX(intent.getIntExtra(MentionActivityConfig.KEY_GO_TO_PAGE, 1));
            if (iX) {
                MentionActivityConfig.newJumpIn = true;
                yVar = this.cfn.cff;
                if (yVar != null) {
                    yVar2 = this.cfn.cff;
                    yVar2.onNewIntent(intent);
                }
            }
        }
    }
}
