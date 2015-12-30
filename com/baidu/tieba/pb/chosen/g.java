package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.cBV = pbChosenActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.chosen.net.b bVar;
        com.baidu.tieba.pb.chosen.net.b bVar2;
        if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && this.cBV.getIntent() != null) {
            long longExtra = this.cBV.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = this.cBV.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = this.cBV.getIntent().getLongExtra("thread_id", 0L);
            com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
            if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                this.cBV.cBJ = true;
                this.cBV.a(chosenData);
            }
            bVar = this.cBV.cBG;
            if (bVar == null) {
                this.cBV.cBG = new com.baidu.tieba.pb.chosen.net.b();
            }
            bVar2 = this.cBV.cBG;
            bVar2.a(this.cBV, longExtra, longExtra2, longExtra3);
        }
    }
}
