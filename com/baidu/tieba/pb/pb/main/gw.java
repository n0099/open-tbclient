package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gw extends CustomMessageListener {
    final /* synthetic */ ReaderPbService epy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw(ReaderPbService readerPbService, int i) {
        super(i);
        this.epy = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ep epVar;
        ep epVar2;
        ep epVar3;
        ep epVar4;
        ep epVar5;
        ep epVar6;
        BdUniqueId bdUniqueId;
        es esVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eo)) {
            eo eoVar = (eo) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = eoVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.epy.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.epy.mTagId = bdUniqueId3;
                    esVar = this.epy.mReaderModel;
                    bdUniqueId2 = this.epy.mTagId;
                    esVar.o(bdUniqueId2);
                }
            }
            this.epy.threadId = eoVar.threadId;
            this.epy.postId = eoVar.postId;
            this.epy.isAlive = eoVar.isAlive;
            this.epy.setReadModel(eoVar);
            if (eoVar.elN >= 0) {
                epVar2 = this.epy.mReaderManager;
                epVar2.a(eoVar.pbData, eoVar.isSquence, eoVar.loadType, eoVar.elM, false);
                epVar3 = this.epy.mReaderManager;
                int aKT = epVar3.aKT();
                if (aKT == 1 || aKT == 3) {
                    epVar4 = this.epy.mReaderManager;
                    epVar4.om(0);
                } else {
                    epVar6 = this.epy.mReaderManager;
                    epVar6.om(1);
                }
                epVar5 = this.epy.mReaderManager;
                epVar5.z(eoVar.elN, eoVar.elP);
                return;
            }
            epVar = this.epy.mReaderManager;
            epVar.a(eoVar.pbData, eoVar.isSquence, eoVar.loadType, eoVar.elM, true);
        }
    }
}
