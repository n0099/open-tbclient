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
    final /* synthetic */ ReaderPbService ewO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh(ReaderPbService readerPbService, int i) {
        super(i);
        this.ewO = readerPbService;
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
                bdUniqueId = this.ewO.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.ewO.releasePbReaderModel();
                    this.ewO.releaseReadManager();
                    this.ewO.mTagId = bdUniqueId4;
                    this.ewO.mReaderManager = new eh();
                    this.ewO.mReaderModel = new ek();
                    ekVar = this.ewO.mReaderModel;
                    bdUniqueId2 = this.ewO.mTagId;
                    ekVar.p(bdUniqueId2);
                    ehVar6 = this.ewO.mReaderManager;
                    aVar = this.ewO.mRefreshCallback;
                    ehVar6.a(aVar);
                    ekVar2 = this.ewO.mReaderModel;
                    aVar2 = this.ewO.mLoadDataCallback;
                    ekVar2.b(aVar2);
                    bdUniqueId3 = this.ewO.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.ewO.threadId = egVar.threadId;
            this.ewO.postId = egVar.postId;
            this.ewO.isAlive = egVar.isAlive;
            this.ewO.setReadModel(egVar);
            if (egVar.ety >= 0) {
                ehVar3 = this.ewO.mReaderManager;
                ehVar3.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.etx);
                ehVar4 = this.ewO.mReaderManager;
                ehVar4.etz = egVar.etz;
                ehVar5 = this.ewO.mReaderManager;
                ehVar5.M(egVar.ety, egVar.etA);
            } else if (egVar.ety == -2) {
                ehVar2 = this.ewO.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.etx, false);
            } else {
                ehVar = this.ewO.mReaderManager;
                ehVar.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.etx);
            }
        }
    }
}
