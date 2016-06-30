package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ge extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge(ReaderPbService readerPbService, int i) {
        super(i);
        this.dVY = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eg egVar;
        eg egVar2;
        eg egVar3;
        eg egVar4;
        eg egVar5;
        eg egVar6;
        BdUniqueId bdUniqueId;
        ej ejVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ef)) {
            ef efVar = (ef) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = efVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.dVY.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.dVY.mTagId = bdUniqueId3;
                    ejVar = this.dVY.mReaderModel;
                    bdUniqueId2 = this.dVY.mTagId;
                    ejVar.p(bdUniqueId2);
                }
            }
            this.dVY.threadId = efVar.threadId;
            this.dVY.postId = efVar.postId;
            this.dVY.isAlive = efVar.isAlive;
            this.dVY.setReadModel(efVar);
            if (efVar.dST >= 0) {
                egVar2 = this.dVY.mReaderManager;
                egVar2.a(efVar.pbData, efVar.isSquence, efVar.loadType, efVar.dSS, false);
                egVar3 = this.dVY.mReaderManager;
                int aGE = egVar3.aGE();
                if (aGE == 1 || aGE == 3) {
                    egVar4 = this.dVY.mReaderManager;
                    egVar4.nt(0);
                } else {
                    egVar6 = this.dVY.mReaderManager;
                    egVar6.nt(1);
                }
                egVar5 = this.dVY.mReaderManager;
                egVar5.I(efVar.dST, efVar.dSV);
                return;
            }
            egVar = this.dVY.mReaderManager;
            egVar.a(efVar.pbData, efVar.isSquence, efVar.loadType, efVar.dSS, true);
        }
    }
}
