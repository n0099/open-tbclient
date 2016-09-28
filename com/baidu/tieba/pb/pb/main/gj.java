package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gj extends CustomMessageListener {
    final /* synthetic */ ReaderPbService ewO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj(ReaderPbService readerPbService, int i) {
        super(i);
        this.ewO = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eh ehVar;
        eh ehVar2;
        eh ehVar3;
        eh ehVar4;
        eh ehVar5;
        eh ehVar6;
        BdUniqueId bdUniqueId;
        ek ekVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eg)) {
            eg egVar = (eg) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = egVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.ewO.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.ewO.mTagId = bdUniqueId3;
                    ekVar = this.ewO.mReaderModel;
                    bdUniqueId2 = this.ewO.mTagId;
                    ekVar.p(bdUniqueId2);
                }
            }
            this.ewO.threadId = egVar.threadId;
            this.ewO.postId = egVar.postId;
            this.ewO.isAlive = egVar.isAlive;
            this.ewO.setReadModel(egVar);
            if (egVar.ety >= 0) {
                ehVar2 = this.ewO.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.etx, false);
                ehVar3 = this.ewO.mReaderManager;
                int aPr = ehVar3.aPr();
                if (aPr == 1 || aPr == 3) {
                    ehVar4 = this.ewO.mReaderManager;
                    ehVar4.oz(0);
                } else {
                    ehVar6 = this.ewO.mReaderManager;
                    ehVar6.oz(1);
                }
                ehVar5 = this.ewO.mReaderManager;
                ehVar5.M(egVar.ety, egVar.etA);
                return;
            }
            ehVar = this.ewO.mReaderManager;
            ehVar.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.etx, true);
        }
    }
}
