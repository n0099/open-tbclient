package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gi extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eiB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi(ReaderPbService readerPbService, int i) {
        super(i);
        this.eiB = readerPbService;
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
                bdUniqueId = this.eiB.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.eiB.mTagId = bdUniqueId3;
                    ekVar = this.eiB.mReaderModel;
                    bdUniqueId2 = this.eiB.mTagId;
                    ekVar.p(bdUniqueId2);
                }
            }
            this.eiB.threadId = egVar.threadId;
            this.eiB.postId = egVar.postId;
            this.eiB.isAlive = egVar.isAlive;
            this.eiB.setReadModel(egVar);
            if (egVar.efk >= 0) {
                ehVar2 = this.eiB.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.efj, false);
                ehVar3 = this.eiB.mReaderManager;
                int aJR = ehVar3.aJR();
                if (aJR == 1 || aJR == 3) {
                    ehVar4 = this.eiB.mReaderManager;
                    ehVar4.nL(0);
                } else {
                    ehVar6 = this.eiB.mReaderManager;
                    ehVar6.nL(1);
                }
                ehVar5 = this.eiB.mReaderManager;
                ehVar5.M(egVar.efk, egVar.efm);
                return;
            }
            ehVar = this.eiB.mReaderManager;
            ehVar.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.efj, true);
        }
    }
}
