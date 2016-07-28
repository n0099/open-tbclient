package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dh;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gg extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eiB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg(ReaderPbService readerPbService, int i) {
        super(i);
        this.eiB = readerPbService;
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
                bdUniqueId = this.eiB.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.eiB.releasePbReaderModel();
                    this.eiB.releaseReadManager();
                    this.eiB.mTagId = bdUniqueId4;
                    this.eiB.mReaderManager = new eh();
                    this.eiB.mReaderModel = new ek();
                    ekVar = this.eiB.mReaderModel;
                    bdUniqueId2 = this.eiB.mTagId;
                    ekVar.p(bdUniqueId2);
                    ehVar6 = this.eiB.mReaderManager;
                    aVar = this.eiB.mRefreshCallback;
                    ehVar6.a(aVar);
                    ekVar2 = this.eiB.mReaderModel;
                    aVar2 = this.eiB.mLoadDataCallback;
                    ekVar2.b(aVar2);
                    bdUniqueId3 = this.eiB.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.eiB.threadId = egVar.threadId;
            this.eiB.postId = egVar.postId;
            this.eiB.isAlive = egVar.isAlive;
            this.eiB.setReadModel(egVar);
            if (egVar.efk >= 0) {
                ehVar3 = this.eiB.mReaderManager;
                ehVar3.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.efj);
                ehVar4 = this.eiB.mReaderManager;
                ehVar4.efl = egVar.efl;
                ehVar5 = this.eiB.mReaderManager;
                ehVar5.M(egVar.efk, egVar.efm);
            } else if (egVar.efk == -2) {
                ehVar2 = this.eiB.mReaderManager;
                ehVar2.a(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.efj, false);
            } else {
                ehVar = this.eiB.mReaderManager;
                ehVar.b(egVar.pbData, egVar.isSquence, egVar.loadType, egVar.efj);
            }
        }
    }
}
