package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dj;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gk extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gk(ReaderPbService readerPbService, int i) {
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
        BdUniqueId bdUniqueId;
        el elVar;
        BdUniqueId bdUniqueId2;
        ei eiVar6;
        ei.a aVar;
        el elVar2;
        dj.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eh)) {
            eh ehVar = (eh) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = ehVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.eDb.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.eDb.releasePbReaderModel();
                    this.eDb.releaseReadManager();
                    this.eDb.mTagId = bdUniqueId4;
                    this.eDb.mReaderManager = new ei();
                    this.eDb.mReaderModel = new el();
                    elVar = this.eDb.mReaderModel;
                    bdUniqueId2 = this.eDb.mTagId;
                    elVar.p(bdUniqueId2);
                    eiVar6 = this.eDb.mReaderManager;
                    aVar = this.eDb.mRefreshCallback;
                    eiVar6.a(aVar);
                    elVar2 = this.eDb.mReaderModel;
                    aVar2 = this.eDb.mLoadDataCallback;
                    elVar2.b(aVar2);
                    bdUniqueId3 = this.eDb.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.eDb.threadId = ehVar.threadId;
            this.eDb.postId = ehVar.postId;
            this.eDb.isAlive = ehVar.isAlive;
            this.eDb.setReadModel(ehVar);
            if (ehVar.ezP >= 0) {
                eiVar3 = this.eDb.mReaderManager;
                eiVar3.b(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.ezO);
                eiVar4 = this.eDb.mReaderManager;
                eiVar4.ezQ = ehVar.ezQ;
                eiVar5 = this.eDb.mReaderManager;
                eiVar5.O(ehVar.ezP, ehVar.ezR);
            } else if (ehVar.ezP == -2) {
                eiVar2 = this.eDb.mReaderManager;
                eiVar2.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.ezO, false);
            } else {
                eiVar = this.eDb.mReaderManager;
                eiVar.b(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.ezO);
            }
        }
    }
}
