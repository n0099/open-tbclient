package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gp extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gp(ReaderPbService readerPbService, int i) {
        super(i);
        this.eqq = readerPbService;
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
                bdUniqueId = this.eqq.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.eqq.mTagId = bdUniqueId3;
                    elVar = this.eqq.mReaderModel;
                    bdUniqueId2 = this.eqq.mTagId;
                    elVar.q(bdUniqueId2);
                }
            }
            this.eqq.threadId = ehVar.threadId;
            this.eqq.postId = ehVar.postId;
            this.eqq.isAlive = ehVar.isAlive;
            this.eqq.setReadModel(ehVar);
            if (ehVar.emS >= 0) {
                eiVar2 = this.eqq.mReaderManager;
                eiVar2.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.emR, false);
                eiVar3 = this.eqq.mReaderManager;
                int aNa = eiVar3.aNa();
                if (aNa == 1 || aNa == 3) {
                    eiVar4 = this.eqq.mReaderManager;
                    eiVar4.oD(0);
                } else {
                    eiVar6 = this.eqq.mReaderManager;
                    eiVar6.oD(1);
                }
                eiVar5 = this.eqq.mReaderManager;
                eiVar5.A(ehVar.emS, ehVar.emU);
                return;
            }
            eiVar = this.eqq.mReaderManager;
            eiVar.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.emR, true);
        }
    }
}
