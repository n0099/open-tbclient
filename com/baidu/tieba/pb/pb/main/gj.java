package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gj extends CustomMessageListener {
    final /* synthetic */ ReaderPbService euI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj(ReaderPbService readerPbService, int i) {
        super(i);
        this.euI = readerPbService;
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
                bdUniqueId = this.euI.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.euI.mTagId = bdUniqueId3;
                    ekVar = this.euI.mReaderModel;
                    bdUniqueId2 = this.euI.mTagId;
                    ekVar.p(bdUniqueId2);
                }
            }
            this.euI.threadId = egVar.threadId;
            this.euI.postId = egVar.postId;
            this.euI.isAlive = egVar.isAlive;
            this.euI.setReadModel(egVar);
            if (egVar.erp >= 0) {
                ehVar2 = this.euI.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.ero, false);
                ehVar3 = this.euI.mReaderManager;
                int aOI = ehVar3.aOI();
                if (aOI == 1 || aOI == 3) {
                    ehVar4 = this.euI.mReaderManager;
                    ehVar4.op(0);
                } else {
                    ehVar6 = this.euI.mReaderManager;
                    ehVar6.op(1);
                }
                ehVar5 = this.euI.mReaderManager;
                ehVar5.M(egVar.erp, egVar.err);
                return;
            }
            ehVar = this.euI.mReaderManager;
            ehVar.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.ero, true);
        }
    }
}
