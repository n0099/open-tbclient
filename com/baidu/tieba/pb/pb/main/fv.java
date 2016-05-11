package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.cw;
import com.baidu.tieba.pb.pb.main.dz;
/* loaded from: classes.dex */
class fv extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fv(ReaderPbService readerPbService, int i) {
        super(i);
        this.dpB = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        dz dzVar4;
        dz dzVar5;
        BdUniqueId bdUniqueId;
        ec ecVar;
        BdUniqueId bdUniqueId2;
        dz dzVar6;
        dz.a aVar;
        ec ecVar2;
        cw.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof dy)) {
            dy dyVar = (dy) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = dyVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.dpB.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.dpB.releasePbReaderModel();
                    this.dpB.releaseReadManager();
                    this.dpB.mTagId = bdUniqueId4;
                    this.dpB.mReaderManager = new dz();
                    this.dpB.mReaderModel = new ec();
                    ecVar = this.dpB.mReaderModel;
                    bdUniqueId2 = this.dpB.mTagId;
                    ecVar.m(bdUniqueId2);
                    dzVar6 = this.dpB.mReaderManager;
                    aVar = this.dpB.mRefreshCallback;
                    dzVar6.a(aVar);
                    ecVar2 = this.dpB.mReaderModel;
                    aVar2 = this.dpB.mLoadDataCallback;
                    ecVar2.b(aVar2);
                    bdUniqueId3 = this.dpB.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.dpB.threadId = dyVar.threadId;
            this.dpB.postId = dyVar.postId;
            this.dpB.isAlive = dyVar.isAlive;
            this.dpB.setReadModel(dyVar);
            if (dyVar.dmC >= 0) {
                dzVar3 = this.dpB.mReaderManager;
                dzVar3.b(dyVar.pbData, dyVar.isSquence, dyVar.loadType, dyVar.dmB);
                dzVar4 = this.dpB.mReaderManager;
                dzVar4.dmD = dyVar.dmD;
                dzVar5 = this.dpB.mReaderManager;
                dzVar5.u(dyVar.dmC, dyVar.dmE);
            } else if (dyVar.dmC == -2) {
                dzVar2 = this.dpB.mReaderManager;
                dzVar2.a(dyVar.pbData, dyVar.isSquence, dyVar.loadType, dyVar.dmB, false);
            } else {
                dzVar = this.dpB.mReaderManager;
                dzVar.b(dyVar.pbData, dyVar.isSquence, dyVar.loadType, dyVar.dmB);
            }
        }
    }
}
