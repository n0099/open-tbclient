package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gp extends CustomMessageListener {
    final /* synthetic */ ReaderPbService etx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gp(ReaderPbService readerPbService, int i) {
        super(i);
        this.etx = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ej ejVar;
        ej ejVar2;
        ej ejVar3;
        ej ejVar4;
        ej ejVar5;
        ej ejVar6;
        BdUniqueId bdUniqueId;
        em emVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ei)) {
            ei eiVar = (ei) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = eiVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.etx.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.etx.mTagId = bdUniqueId3;
                    emVar = this.etx.mReaderModel;
                    bdUniqueId2 = this.etx.mTagId;
                    emVar.p(bdUniqueId2);
                }
            }
            this.etx.threadId = eiVar.threadId;
            this.etx.postId = eiVar.postId;
            this.etx.isAlive = eiVar.isAlive;
            this.etx.setReadModel(eiVar);
            if (eiVar.epS >= 0) {
                ejVar2 = this.etx.mReaderManager;
                ejVar2.a(eiVar.pbData, eiVar.isSquence, eiVar.loadType, eiVar.epR, false);
                ejVar3 = this.etx.mReaderManager;
                int aMt = ejVar3.aMt();
                if (aMt == 1 || aMt == 3) {
                    ejVar4 = this.etx.mReaderManager;
                    ejVar4.or(0);
                } else {
                    ejVar6 = this.etx.mReaderManager;
                    ejVar6.or(1);
                }
                ejVar5 = this.etx.mReaderManager;
                ejVar5.A(eiVar.epS, eiVar.epU);
                return;
            }
            ejVar = this.etx.mReaderManager;
            ejVar.a(eiVar.pbData, eiVar.isSquence, eiVar.loadType, eiVar.epR, true);
        }
    }
}
