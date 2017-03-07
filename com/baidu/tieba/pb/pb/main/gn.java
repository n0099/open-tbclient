package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ej;
/* loaded from: classes.dex */
class gn extends CustomMessageListener {
    final /* synthetic */ ReaderPbService etx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gn(ReaderPbService readerPbService, int i) {
        super(i);
        this.etx = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ej ejVar;
        ej ejVar2;
        ej ejVar3;
        ej ejVar4;
        ej ejVar5;
        BdUniqueId bdUniqueId;
        em emVar;
        BdUniqueId bdUniqueId2;
        ej ejVar6;
        ej.a aVar;
        em emVar2;
        PbModel.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ei)) {
            ei eiVar = (ei) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = eiVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.etx.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.etx.releasePbReaderModel();
                    this.etx.releaseReadManager();
                    this.etx.mTagId = bdUniqueId4;
                    this.etx.mReaderManager = new ej();
                    this.etx.mReaderModel = new em();
                    emVar = this.etx.mReaderModel;
                    bdUniqueId2 = this.etx.mTagId;
                    emVar.p(bdUniqueId2);
                    ejVar6 = this.etx.mReaderManager;
                    aVar = this.etx.mRefreshCallback;
                    ejVar6.a(aVar);
                    emVar2 = this.etx.mReaderModel;
                    aVar2 = this.etx.mLoadDataCallback;
                    emVar2.b(aVar2);
                    bdUniqueId3 = this.etx.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.etx.threadId = eiVar.threadId;
            this.etx.postId = eiVar.postId;
            this.etx.isAlive = eiVar.isAlive;
            this.etx.setReadModel(eiVar);
            if (eiVar.epS >= 0) {
                ejVar3 = this.etx.mReaderManager;
                ejVar3.b(eiVar.pbData, eiVar.isSquence, eiVar.loadType, eiVar.epR);
                ejVar4 = this.etx.mReaderManager;
                ejVar4.epT = eiVar.epT;
                ejVar5 = this.etx.mReaderManager;
                ejVar5.A(eiVar.epS, eiVar.epU);
            } else if (eiVar.epS == -2) {
                ejVar2 = this.etx.mReaderManager;
                ejVar2.a(eiVar.pbData, eiVar.isSquence, eiVar.loadType, eiVar.epR, false);
            } else {
                ejVar = this.etx.mReaderManager;
                ejVar.b(eiVar.pbData, eiVar.isSquence, eiVar.loadType, eiVar.epR);
            }
        }
    }
}
