package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class fj extends CustomMessageListener {
    final /* synthetic */ ReaderPbService cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(ReaderPbService readerPbService, int i) {
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
        dn dnVar5;
        dn dnVar6;
        BdUniqueId bdUniqueId;
        dq dqVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof dm)) {
            dm dmVar = (dm) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = dmVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.cSC.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.cSC.mTagId = bdUniqueId3;
                    dqVar = this.cSC.mReaderModel;
                    bdUniqueId2 = this.cSC.mTagId;
                    dqVar.l(bdUniqueId2);
                }
            }
            this.cSC.threadId = dmVar.threadId;
            this.cSC.postId = dmVar.postId;
            this.cSC.isAlive = dmVar.isAlive;
            this.cSC.setReadModel(dmVar);
            if (dmVar.cPN >= 0) {
                dnVar2 = this.cSC.mReaderManager;
                dnVar2.a(dmVar.pbData, dmVar.isSquence, dmVar.loadType, dmVar.cPM, false);
                dnVar3 = this.cSC.mReaderManager;
                int aqB = dnVar3.aqB();
                if (aqB == 1 || aqB == 3) {
                    dnVar4 = this.cSC.mReaderManager;
                    dnVar4.kY(0);
                } else {
                    dnVar6 = this.cSC.mReaderManager;
                    dnVar6.kY(1);
                }
                dnVar5 = this.cSC.mReaderManager;
                dnVar5.s(dmVar.cPN, dmVar.cPO);
                return;
            }
            dnVar = this.cSC.mReaderManager;
            dnVar.a(dmVar.pbData, dmVar.isSquence, dmVar.loadType, dmVar.cPM, true);
        }
    }
}
