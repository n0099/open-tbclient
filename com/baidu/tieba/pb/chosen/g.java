package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity cyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.cyo = pbChosenActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.chosen.net.b bVar;
        com.baidu.tieba.pb.chosen.net.b bVar2;
        if ((customResponsedMessage instanceof ReadChosenPbCacheResponse) && this.cyo.getIntent() != null) {
            long longExtra = this.cyo.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = this.cyo.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = this.cyo.getIntent().getLongExtra("thread_id", 0L);
            com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
            if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                this.cyo.cyc = true;
                this.cyo.a(chosenData);
            }
            bVar = this.cyo.cxZ;
            if (bVar == null) {
                this.cyo.cxZ = new com.baidu.tieba.pb.chosen.net.b();
            }
            bVar2 = this.cyo.cxZ;
            bVar2.a(this.cyo, longExtra, longExtra2, longExtra3);
        }
    }
}
