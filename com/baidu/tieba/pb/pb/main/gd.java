package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dc;
import com.baidu.tieba.pb.pb.main.eb;
/* loaded from: classes.dex */
class gd extends CustomMessageListener {
    final /* synthetic */ ReaderPbService ehh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(ReaderPbService readerPbService, int i) {
        super(i);
        this.ehh = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eb ebVar;
        eb ebVar2;
        eb ebVar3;
        eb ebVar4;
        eb ebVar5;
        BdUniqueId bdUniqueId;
        ee eeVar;
        BdUniqueId bdUniqueId2;
        eb ebVar6;
        eb.a aVar;
        ee eeVar2;
        dc.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ea)) {
            ea eaVar = (ea) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = eaVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.ehh.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.ehh.releasePbReaderModel();
                    this.ehh.releaseReadManager();
                    this.ehh.mTagId = bdUniqueId4;
                    this.ehh.mReaderManager = new eb();
                    this.ehh.mReaderModel = new ee();
                    eeVar = this.ehh.mReaderModel;
                    bdUniqueId2 = this.ehh.mTagId;
                    eeVar.p(bdUniqueId2);
                    ebVar6 = this.ehh.mReaderManager;
                    aVar = this.ehh.mRefreshCallback;
                    ebVar6.a(aVar);
                    eeVar2 = this.ehh.mReaderModel;
                    aVar2 = this.ehh.mLoadDataCallback;
                    eeVar2.b(aVar2);
                    bdUniqueId3 = this.ehh.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.ehh.threadId = eaVar.threadId;
            this.ehh.postId = eaVar.postId;
            this.ehh.isAlive = eaVar.isAlive;
            this.ehh.setReadModel(eaVar);
            if (eaVar.edY >= 0) {
                ebVar3 = this.ehh.mReaderManager;
                ebVar3.b(eaVar.pbData, eaVar.isSquence, eaVar.loadType, eaVar.edX);
                ebVar4 = this.ehh.mReaderManager;
                ebVar4.edZ = eaVar.edZ;
                ebVar5 = this.ehh.mReaderManager;
                ebVar5.A(eaVar.edY, eaVar.eea);
            } else if (eaVar.edY == -2) {
                ebVar2 = this.ehh.mReaderManager;
                ebVar2.a(eaVar.pbData, eaVar.isSquence, eaVar.loadType, eaVar.edX, false);
            } else {
                ebVar = this.ehh.mReaderManager;
                ebVar.b(eaVar.pbData, eaVar.isSquence, eaVar.loadType, eaVar.edX);
            }
        }
    }
}
