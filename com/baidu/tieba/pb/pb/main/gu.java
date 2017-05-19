package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ep;
/* loaded from: classes.dex */
class gu extends CustomMessageListener {
    final /* synthetic */ ReaderPbService epy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu(ReaderPbService readerPbService, int i) {
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
        BdUniqueId bdUniqueId;
        es esVar;
        BdUniqueId bdUniqueId2;
        ep epVar6;
        ep.a aVar;
        es esVar2;
        PbModel.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eo)) {
            eo eoVar = (eo) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = eoVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.epy.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.epy.releasePbReaderModel();
                    this.epy.releaseReadManager();
                    this.epy.mTagId = bdUniqueId4;
                    this.epy.mReaderManager = new ep();
                    this.epy.mReaderModel = new es();
                    esVar = this.epy.mReaderModel;
                    bdUniqueId2 = this.epy.mTagId;
                    esVar.o(bdUniqueId2);
                    epVar6 = this.epy.mReaderManager;
                    aVar = this.epy.mRefreshCallback;
                    epVar6.a(aVar);
                    esVar2 = this.epy.mReaderModel;
                    aVar2 = this.epy.mLoadDataCallback;
                    esVar2.b(aVar2);
                    bdUniqueId3 = this.epy.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.epy.threadId = eoVar.threadId;
            this.epy.postId = eoVar.postId;
            this.epy.isAlive = eoVar.isAlive;
            this.epy.setReadModel(eoVar);
            if (eoVar.elN >= 0) {
                epVar3 = this.epy.mReaderManager;
                epVar3.b(eoVar.pbData, eoVar.isSquence, eoVar.loadType, eoVar.elM);
                epVar4 = this.epy.mReaderManager;
                epVar4.elO = eoVar.elO;
                epVar5 = this.epy.mReaderManager;
                epVar5.z(eoVar.elN, eoVar.elP);
            } else if (eoVar.elN == -2) {
                epVar2 = this.epy.mReaderManager;
                epVar2.a(eoVar.pbData, eoVar.isSquence, eoVar.loadType, eoVar.elM, false);
            } else {
                epVar = this.epy.mReaderManager;
                epVar.b(eoVar.pbData, eoVar.isSquence, eoVar.loadType, eoVar.elM);
            }
        }
    }
}
