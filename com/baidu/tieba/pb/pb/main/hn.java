package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.fh;
/* loaded from: classes.dex */
class hn extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hn(ReaderPbService readerPbService, int i) {
        super(i);
        this.eEB = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fh fhVar;
        fh fhVar2;
        fh fhVar3;
        fh fhVar4;
        fh fhVar5;
        BdUniqueId bdUniqueId;
        fk fkVar;
        BdUniqueId bdUniqueId2;
        fh fhVar6;
        fh.a aVar;
        fk fkVar2;
        PbModel.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof fg)) {
            fg fgVar = (fg) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = fgVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.eEB.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.eEB.releasePbReaderModel();
                    this.eEB.releaseReadManager();
                    this.eEB.mTagId = bdUniqueId4;
                    this.eEB.mReaderManager = new fh();
                    this.eEB.mReaderModel = new fk();
                    fkVar = this.eEB.mReaderModel;
                    bdUniqueId2 = this.eEB.mTagId;
                    fkVar.n(bdUniqueId2);
                    fhVar6 = this.eEB.mReaderManager;
                    aVar = this.eEB.mRefreshCallback;
                    fhVar6.a(aVar);
                    fkVar2 = this.eEB.mReaderModel;
                    aVar2 = this.eEB.mLoadDataCallback;
                    fkVar2.b(aVar2);
                    bdUniqueId3 = this.eEB.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.eEB.threadId = fgVar.threadId;
            this.eEB.postId = fgVar.postId;
            this.eEB.isAlive = fgVar.isAlive;
            this.eEB.setReadModel(fgVar);
            if (fgVar.eAL >= 0) {
                fhVar3 = this.eEB.mReaderManager;
                fhVar3.b(fgVar.pbData, fgVar.isSquence, fgVar.loadType, fgVar.eAK);
                fhVar4 = this.eEB.mReaderManager;
                fhVar4.eAM = fgVar.eAM;
                fhVar5 = this.eEB.mReaderManager;
                fhVar5.z(fgVar.eAL, fgVar.eAN);
            } else if (fgVar.eAL == -2) {
                fhVar2 = this.eEB.mReaderManager;
                fhVar2.a(fgVar.pbData, fgVar.isSquence, fgVar.loadType, fgVar.eAK, false);
            } else {
                fhVar = this.eEB.mReaderManager;
                fhVar.b(fgVar.pbData, fgVar.isSquence, fgVar.loadType, fgVar.eAK);
            }
        }
    }
}
