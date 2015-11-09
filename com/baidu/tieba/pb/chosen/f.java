package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbChosenActivity pbChosenActivity, int i) {
        super(i);
        this.cfM = pbChosenActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.chosen.net.b bVar;
        com.baidu.tieba.pb.chosen.net.b bVar2;
        if (customResponsedMessage instanceof ReadChosenPbCacheResponse) {
            long longExtra = this.cfM.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            com.baidu.tieba.pb.chosen.net.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
            if (chosenData != null && chosenData.getForumInfo() != null && chosenData.getForumInfo().ftid != null && longExtra == chosenData.getForumInfo().ftid.longValue()) {
                this.cfM.cfC = true;
                this.cfM.a(chosenData);
            }
            bVar = this.cfM.cfz;
            if (bVar == null) {
                this.cfM.cfz = new com.baidu.tieba.pb.chosen.net.b();
            }
            bVar2 = this.cfM.cfz;
            bVar2.a(this.cfM, longExtra);
        }
    }
}
