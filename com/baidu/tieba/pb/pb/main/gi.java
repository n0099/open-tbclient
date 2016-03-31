package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gi extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi(ReaderPbService readerPbService, int i) {
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
        BdUniqueId bdUniqueId;
        el elVar;
        BdUniqueId bdUniqueId2;
        ei eiVar5;
        ei.a aVar;
        el elVar2;
        df.c cVar;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eh)) {
            eh ehVar = (eh) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = ehVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.dnu.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.dnu.releasePbReaderModel();
                    this.dnu.releaseReadManager();
                    this.dnu.mTagId = bdUniqueId4;
                    this.dnu.mReaderManager = new ei();
                    this.dnu.mReaderModel = new el();
                    elVar = this.dnu.mReaderModel;
                    bdUniqueId2 = this.dnu.mTagId;
                    elVar.m(bdUniqueId2);
                    eiVar5 = this.dnu.mReaderManager;
                    aVar = this.dnu.mRefreshCallback;
                    eiVar5.a(aVar);
                    elVar2 = this.dnu.mReaderModel;
                    cVar = this.dnu.mLoadDataCallback;
                    elVar2.b(cVar);
                    bdUniqueId3 = this.dnu.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.dnu.threadId = ehVar.threadId;
            this.dnu.postId = ehVar.postId;
            this.dnu.isAlive = ehVar.isAlive;
            this.dnu.setReadModel(ehVar);
            if (ehVar.dke >= 0) {
                eiVar3 = this.dnu.mReaderManager;
                eiVar3.b(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.dkd);
                eiVar4 = this.dnu.mReaderManager;
                eiVar4.s(ehVar.dke, ehVar.dkf);
            } else if (ehVar.dke == -2) {
                eiVar2 = this.dnu.mReaderManager;
                eiVar2.a(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.dkd, false);
            } else {
                eiVar = this.dnu.mReaderManager;
                eiVar.b(ehVar.pbData, ehVar.isSquence, ehVar.loadType, ehVar.dkd);
            }
        }
    }
}
