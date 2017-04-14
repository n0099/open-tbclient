package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gl extends CustomMessageListener {
    final /* synthetic */ ReaderPbService erF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gl(ReaderPbService readerPbService, int i) {
        super(i);
        this.erF = readerPbService;
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
        PbModel.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof eg)) {
            eg egVar = (eg) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = egVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.erF.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.erF.releasePbReaderModel();
                    this.erF.releaseReadManager();
                    this.erF.mTagId = bdUniqueId4;
                    this.erF.mReaderManager = new eh();
                    this.erF.mReaderModel = new ek();
                    ekVar = this.erF.mReaderModel;
                    bdUniqueId2 = this.erF.mTagId;
                    ekVar.p(bdUniqueId2);
                    ehVar6 = this.erF.mReaderManager;
                    aVar = this.erF.mRefreshCallback;
                    ehVar6.a(aVar);
                    ekVar2 = this.erF.mReaderModel;
                    aVar2 = this.erF.mLoadDataCallback;
                    ekVar2.b(aVar2);
                    bdUniqueId3 = this.erF.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.erF.threadId = egVar.threadId;
            this.erF.postId = egVar.postId;
            this.erF.isAlive = egVar.isAlive;
            this.erF.setReadModel(egVar);
            if (egVar.eoa >= 0) {
                ehVar3 = this.erF.mReaderManager;
                ehVar3.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.enZ);
                ehVar4 = this.erF.mReaderManager;
                ehVar4.eob = egVar.eob;
                ehVar5 = this.erF.mReaderManager;
                ehVar5.A(egVar.eoa, egVar.eoc);
            } else if (egVar.eoa == -2) {
                ehVar2 = this.erF.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.enZ, false);
            } else {
                ehVar = this.erF.mReaderManager;
                ehVar.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.enZ);
            }
        }
    }
}
