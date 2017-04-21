package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gn extends CustomMessageListener {
    final /* synthetic */ ReaderPbService etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn(ReaderPbService readerPbService, int i) {
        super(i);
        this.etX = readerPbService;
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
                bdUniqueId = this.etX.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.etX.mTagId = bdUniqueId3;
                    ekVar = this.etX.mReaderModel;
                    bdUniqueId2 = this.etX.mTagId;
                    ekVar.p(bdUniqueId2);
                }
            }
            this.etX.threadId = egVar.threadId;
            this.etX.postId = egVar.postId;
            this.etX.isAlive = egVar.isAlive;
            this.etX.setReadModel(egVar);
            if (egVar.eqs >= 0) {
                ehVar2 = this.etX.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.eqr, false);
                ehVar3 = this.etX.mReaderManager;
                int aND = ehVar3.aND();
                if (aND == 1 || aND == 3) {
                    ehVar4 = this.etX.mReaderManager;
                    ehVar4.ov(0);
                } else {
                    ehVar6 = this.etX.mReaderManager;
                    ehVar6.ov(1);
                }
                ehVar5 = this.etX.mReaderManager;
                ehVar5.A(egVar.eqs, egVar.equ);
                return;
            }
            ehVar = this.etX.mReaderManager;
            ehVar.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.eqr, true);
        }
    }
}
