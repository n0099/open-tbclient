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
    final /* synthetic */ ReaderPbService etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gl(ReaderPbService readerPbService, int i) {
        super(i);
        this.etX = readerPbService;
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
                bdUniqueId = this.etX.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.etX.releasePbReaderModel();
                    this.etX.releaseReadManager();
                    this.etX.mTagId = bdUniqueId4;
                    this.etX.mReaderManager = new eh();
                    this.etX.mReaderModel = new ek();
                    ekVar = this.etX.mReaderModel;
                    bdUniqueId2 = this.etX.mTagId;
                    ekVar.p(bdUniqueId2);
                    ehVar6 = this.etX.mReaderManager;
                    aVar = this.etX.mRefreshCallback;
                    ehVar6.a(aVar);
                    ekVar2 = this.etX.mReaderModel;
                    aVar2 = this.etX.mLoadDataCallback;
                    ekVar2.b(aVar2);
                    bdUniqueId3 = this.etX.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.etX.threadId = egVar.threadId;
            this.etX.postId = egVar.postId;
            this.etX.isAlive = egVar.isAlive;
            this.etX.setReadModel(egVar);
            if (egVar.eqs >= 0) {
                ehVar3 = this.etX.mReaderManager;
                ehVar3.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.eqr);
                ehVar4 = this.etX.mReaderManager;
                ehVar4.eqt = egVar.eqt;
                ehVar5 = this.etX.mReaderManager;
                ehVar5.A(egVar.eqs, egVar.equ);
            } else if (egVar.eqs == -2) {
                ehVar2 = this.etX.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.eqr, false);
            } else {
                ehVar = this.etX.mReaderManager;
                ehVar.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.eqr);
            }
        }
    }
}
