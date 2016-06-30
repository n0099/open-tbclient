package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dg;
import com.baidu.tieba.pb.pb.main.eg;
/* loaded from: classes.dex */
class gc extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc(ReaderPbService readerPbService, int i) {
        super(i);
        this.dVY = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eg egVar;
        eg egVar2;
        eg egVar3;
        eg egVar4;
        eg egVar5;
        BdUniqueId bdUniqueId;
        ej ejVar;
        BdUniqueId bdUniqueId2;
        eg egVar6;
        eg.a aVar;
        ej ejVar2;
        dg.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ef)) {
            ef efVar = (ef) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = efVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.dVY.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.dVY.releasePbReaderModel();
                    this.dVY.releaseReadManager();
                    this.dVY.mTagId = bdUniqueId4;
                    this.dVY.mReaderManager = new eg();
                    this.dVY.mReaderModel = new ej();
                    ejVar = this.dVY.mReaderModel;
                    bdUniqueId2 = this.dVY.mTagId;
                    ejVar.p(bdUniqueId2);
                    egVar6 = this.dVY.mReaderManager;
                    aVar = this.dVY.mRefreshCallback;
                    egVar6.a(aVar);
                    ejVar2 = this.dVY.mReaderModel;
                    aVar2 = this.dVY.mLoadDataCallback;
                    ejVar2.b(aVar2);
                    bdUniqueId3 = this.dVY.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.dVY.threadId = efVar.threadId;
            this.dVY.postId = efVar.postId;
            this.dVY.isAlive = efVar.isAlive;
            this.dVY.setReadModel(efVar);
            if (efVar.dST >= 0) {
                egVar3 = this.dVY.mReaderManager;
                egVar3.b(efVar.pbData, efVar.isSquence, efVar.loadType, efVar.dSS);
                egVar4 = this.dVY.mReaderManager;
                egVar4.dSU = efVar.dSU;
                egVar5 = this.dVY.mReaderManager;
                egVar5.I(efVar.dST, efVar.dSV);
            } else if (efVar.dST == -2) {
                egVar2 = this.dVY.mReaderManager;
                egVar2.a(efVar.pbData, efVar.isSquence, efVar.loadType, efVar.dSS, false);
            } else {
                egVar = this.dVY.mReaderManager;
                egVar.b(efVar.pbData, efVar.isSquence, efVar.loadType, efVar.dSS);
            }
        }
    }
}
