package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gh extends CustomMessageListener {
    final /* synthetic */ ReaderPbService euI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh(ReaderPbService readerPbService, int i) {
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
        BdUniqueId bdUniqueId;
        ek ekVar;
        BdUniqueId bdUniqueId2;
        eh ehVar6;
        eh.a aVar;
        ek ekVar2;
        dh.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eg)) {
            eg egVar = (eg) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = egVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.euI.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.euI.releasePbReaderModel();
                    this.euI.releaseReadManager();
                    this.euI.mTagId = bdUniqueId4;
                    this.euI.mReaderManager = new eh();
                    this.euI.mReaderModel = new ek();
                    ekVar = this.euI.mReaderModel;
                    bdUniqueId2 = this.euI.mTagId;
                    ekVar.p(bdUniqueId2);
                    ehVar6 = this.euI.mReaderManager;
                    aVar = this.euI.mRefreshCallback;
                    ehVar6.a(aVar);
                    ekVar2 = this.euI.mReaderModel;
                    aVar2 = this.euI.mLoadDataCallback;
                    ekVar2.b(aVar2);
                    bdUniqueId3 = this.euI.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.euI.threadId = egVar.threadId;
            this.euI.postId = egVar.postId;
            this.euI.isAlive = egVar.isAlive;
            this.euI.setReadModel(egVar);
            if (egVar.erp >= 0) {
                ehVar3 = this.euI.mReaderManager;
                ehVar3.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.ero);
                ehVar4 = this.euI.mReaderManager;
                ehVar4.erq = egVar.erq;
                ehVar5 = this.euI.mReaderManager;
                ehVar5.M(egVar.erp, egVar.err);
            } else if (egVar.erp == -2) {
                ehVar2 = this.euI.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.ero, false);
            } else {
                ehVar = this.euI.mReaderManager;
                ehVar.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.ero);
            }
        }
    }
}
