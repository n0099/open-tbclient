package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class gf extends CustomMessageListener {
    final /* synthetic */ ReaderPbService ehh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf(ReaderPbService readerPbService, int i) {
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
        eb ebVar6;
        BdUniqueId bdUniqueId;
        ee eeVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ea)) {
            ea eaVar = (ea) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = eaVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.ehh.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.ehh.mTagId = bdUniqueId3;
                    eeVar = this.ehh.mReaderModel;
                    bdUniqueId2 = this.ehh.mTagId;
                    eeVar.p(bdUniqueId2);
                }
            }
            this.ehh.threadId = eaVar.threadId;
            this.ehh.postId = eaVar.postId;
            this.ehh.isAlive = eaVar.isAlive;
            this.ehh.setReadModel(eaVar);
            if (eaVar.edY >= 0) {
                ebVar2 = this.ehh.mReaderManager;
                ebVar2.a(eaVar.pbData, eaVar.isSquence, eaVar.loadType, eaVar.edX, false);
                ebVar3 = this.ehh.mReaderManager;
                int aLm = ebVar3.aLm();
                if (aLm == 1 || aLm == 3) {
                    ebVar4 = this.ehh.mReaderManager;
                    ebVar4.nM(0);
                } else {
                    ebVar6 = this.ehh.mReaderManager;
                    ebVar6.nM(1);
                }
                ebVar5 = this.ehh.mReaderManager;
                ebVar5.A(eaVar.edY, eaVar.eea);
                return;
            }
            ebVar = this.ehh.mReaderManager;
            ebVar.a(eaVar.pbData, eaVar.isSquence, eaVar.loadType, eaVar.edX, true);
        }
    }
}
