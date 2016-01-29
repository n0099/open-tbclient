package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.pb.pb.main.dn;
/* loaded from: classes.dex */
class fh extends CustomMessageListener {
    final /* synthetic */ ReaderPbService cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh(ReaderPbService readerPbService, int i) {
        super(i);
        this.cSC = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dn dnVar;
        dn dnVar2;
        dn dnVar3;
        dn dnVar4;
        BdUniqueId bdUniqueId;
        dq dqVar;
        BdUniqueId bdUniqueId2;
        dn dnVar5;
        dn.a aVar;
        dq dqVar2;
        cm.c cVar;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof dm)) {
            dm dmVar = (dm) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = dmVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.cSC.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.cSC.releasePbReaderModel();
                    this.cSC.releaseReadManager();
                    this.cSC.mTagId = bdUniqueId4;
                    this.cSC.mReaderManager = new dn();
                    this.cSC.mReaderModel = new dq();
                    dqVar = this.cSC.mReaderModel;
                    bdUniqueId2 = this.cSC.mTagId;
                    dqVar.l(bdUniqueId2);
                    dnVar5 = this.cSC.mReaderManager;
                    aVar = this.cSC.mRefreshCallback;
                    dnVar5.a(aVar);
                    dqVar2 = this.cSC.mReaderModel;
                    cVar = this.cSC.mLoadDataCallback;
                    dqVar2.b(cVar);
                    bdUniqueId3 = this.cSC.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.cSC.threadId = dmVar.threadId;
            this.cSC.postId = dmVar.postId;
            this.cSC.isAlive = dmVar.isAlive;
            this.cSC.setReadModel(dmVar);
            if (dmVar.cPN >= 0) {
                dnVar3 = this.cSC.mReaderManager;
                dnVar3.b(dmVar.pbData, dmVar.isSquence, dmVar.loadType, dmVar.cPM);
                dnVar4 = this.cSC.mReaderManager;
                dnVar4.s(dmVar.cPN, dmVar.cPO);
            } else if (dmVar.cPN == -2) {
                dnVar2 = this.cSC.mReaderManager;
                dnVar2.a(dmVar.pbData, dmVar.isSquence, dmVar.loadType, dmVar.cPM, false);
            } else {
                dnVar = this.cSC.mReaderManager;
                dnVar.b(dmVar.pbData, dmVar.isSquence, dmVar.loadType, dmVar.cPM);
            }
        }
    }
}
