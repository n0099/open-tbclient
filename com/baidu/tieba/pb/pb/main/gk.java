package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gk extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gk(ReaderPbService readerPbService, int i) {
        super(i);
        this.dnu = readerPbService;
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
                bdUniqueId = this.dnu.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.dnu.mTagId = bdUniqueId3;
                    elVar = this.dnu.mReaderModel;
                    bdUniqueId2 = this.dnu.mTagId;
                    elVar.m(bdUniqueId2);
                }
            }
            this.dnu.threadId = ehVar.threadId;
            this.dnu.postId = ehVar.postId;
            this.dnu.isAlive = ehVar.isAlive;
            this.dnu.setReadModel(ehVar);
            if (ehVar.dke >= 0) {
                eiVar2 = this.dnu.mReaderManager;
                eiVar2.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.dkd, false);
                eiVar3 = this.dnu.mReaderManager;
                int axR = eiVar3.axR();
                if (axR == 1 || axR == 3) {
                    eiVar4 = this.dnu.mReaderManager;
                    eiVar4.mg(0);
                } else {
                    eiVar6 = this.dnu.mReaderManager;
                    eiVar6.mg(1);
                }
                eiVar5 = this.dnu.mReaderManager;
                eiVar5.s(ehVar.dke, ehVar.dkf);
                return;
            }
            eiVar = this.dnu.mReaderManager;
            eiVar.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.dkd, true);
        }
    }
}
