package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.bFY = pbChosenActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ReadChosenPbCacheResponse) {
            long longExtra = this.bFY.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
            if (chosenData != null && chosenData.getForumInfo() != null && chosenData.getForumInfo().ftid != null && longExtra == chosenData.getForumInfo().ftid.longValue()) {
                this.bFY.bFR = true;
                this.bFY.a(chosenData);
            }
            this.bFY.ai(longExtra);
        }
    }
}
