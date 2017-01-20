package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gn extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn(ReaderPbService readerPbService, int i) {
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
        BdUniqueId bdUniqueId;
        el elVar;
        BdUniqueId bdUniqueId2;
        ei eiVar6;
        ei.a aVar;
        el elVar2;
        PbModel.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eh)) {
            eh ehVar = (eh) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = ehVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.eqq.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.eqq.releasePbReaderModel();
                    this.eqq.releaseReadManager();
                    this.eqq.mTagId = bdUniqueId4;
                    this.eqq.mReaderManager = new ei();
                    this.eqq.mReaderModel = new el();
                    elVar = this.eqq.mReaderModel;
                    bdUniqueId2 = this.eqq.mTagId;
                    elVar.q(bdUniqueId2);
                    eiVar6 = this.eqq.mReaderManager;
                    aVar = this.eqq.mRefreshCallback;
                    eiVar6.a(aVar);
                    elVar2 = this.eqq.mReaderModel;
                    aVar2 = this.eqq.mLoadDataCallback;
                    elVar2.b(aVar2);
                    bdUniqueId3 = this.eqq.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.eqq.threadId = ehVar.threadId;
            this.eqq.postId = ehVar.postId;
            this.eqq.isAlive = ehVar.isAlive;
            this.eqq.setReadModel(ehVar);
            if (ehVar.emS >= 0) {
                eiVar3 = this.eqq.mReaderManager;
                eiVar3.b(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.emR);
                eiVar4 = this.eqq.mReaderManager;
                eiVar4.emT = ehVar.emT;
                eiVar5 = this.eqq.mReaderManager;
                eiVar5.A(ehVar.emS, ehVar.emU);
            } else if (ehVar.emS == -2) {
                eiVar2 = this.eqq.mReaderManager;
                eiVar2.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.emR, false);
            } else {
                eiVar = this.eqq.mReaderManager;
                eiVar.b(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.emR);
            }
        }
    }
}
