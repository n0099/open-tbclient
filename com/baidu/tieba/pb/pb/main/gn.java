package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gn extends CustomMessageListener {
    final /* synthetic */ ReaderPbService erF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn(ReaderPbService readerPbService, int i) {
        super(i);
        this.erF = readerPbService;
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
                bdUniqueId = this.erF.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.erF.mTagId = bdUniqueId3;
                    ekVar = this.erF.mReaderModel;
                    bdUniqueId2 = this.erF.mTagId;
                    ekVar.p(bdUniqueId2);
                }
            }
            this.erF.threadId = egVar.threadId;
            this.erF.postId = egVar.postId;
            this.erF.isAlive = egVar.isAlive;
            this.erF.setReadModel(egVar);
            if (egVar.eoa >= 0) {
                ehVar2 = this.erF.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.enZ, false);
                ehVar3 = this.erF.mReaderManager;
                int aMC = ehVar3.aMC();
                if (aMC == 1 || aMC == 3) {
                    ehVar4 = this.erF.mReaderManager;
                    ehVar4.op(0);
                } else {
                    ehVar6 = this.erF.mReaderManager;
                    ehVar6.op(1);
                }
                ehVar5 = this.erF.mReaderManager;
                ehVar5.A(egVar.eoa, egVar.eoc);
                return;
            }
            ehVar = this.erF.mReaderManager;
            ehVar.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.enZ, true);
        }
    }
}
