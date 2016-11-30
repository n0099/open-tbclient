package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gm extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm(ReaderPbService readerPbService, int i) {
        super(i);
        this.eDb = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ei eiVar;
        ei eiVar2;
        ei eiVar3;
        ei eiVar4;
        ei eiVar5;
        ei eiVar6;
        BdUniqueId bdUniqueId;
        el elVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eh)) {
            eh ehVar = (eh) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = ehVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.eDb.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.eDb.mTagId = bdUniqueId3;
                    elVar = this.eDb.mReaderModel;
                    bdUniqueId2 = this.eDb.mTagId;
                    elVar.p(bdUniqueId2);
                }
            }
            this.eDb.threadId = ehVar.threadId;
            this.eDb.postId = ehVar.postId;
            this.eDb.isAlive = ehVar.isAlive;
            this.eDb.setReadModel(ehVar);
            if (ehVar.ezP >= 0) {
                eiVar2 = this.eDb.mReaderManager;
                eiVar2.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.ezO, false);
                eiVar3 = this.eDb.mReaderManager;
                int aRs = eiVar3.aRs();
                if (aRs == 1 || aRs == 3) {
                    eiVar4 = this.eDb.mReaderManager;
                    eiVar4.oK(0);
                } else {
                    eiVar6 = this.eDb.mReaderManager;
                    eiVar6.oK(1);
                }
                eiVar5 = this.eDb.mReaderManager;
                eiVar5.O(ehVar.ezP, ehVar.ezR);
                return;
            }
            eiVar = this.eDb.mReaderManager;
            eiVar.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.ezO, true);
        }
    }
}
