package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class fx extends CustomMessageListener {
    final /* synthetic */ ReaderPbService dpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx(ReaderPbService readerPbService, int i) {
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
        dz dzVar6;
        BdUniqueId bdUniqueId;
        ec ecVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof dy)) {
            dy dyVar = (dy) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = dyVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.dpB.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.dpB.mTagId = bdUniqueId3;
                    ecVar = this.dpB.mReaderModel;
                    bdUniqueId2 = this.dpB.mTagId;
                    ecVar.m(bdUniqueId2);
                }
            }
            this.dpB.threadId = dyVar.threadId;
            this.dpB.postId = dyVar.postId;
            this.dpB.isAlive = dyVar.isAlive;
            this.dpB.setReadModel(dyVar);
            if (dyVar.dmC >= 0) {
                dzVar2 = this.dpB.mReaderManager;
                dzVar2.a(dyVar.pbData, dyVar.isSquence, dyVar.loadType, dyVar.dmB, false);
                dzVar3 = this.dpB.mReaderManager;
                int ayv = dzVar3.ayv();
                if (ayv == 1 || ayv == 3) {
                    dzVar4 = this.dpB.mReaderManager;
                    dzVar4.lU(0);
                } else {
                    dzVar6 = this.dpB.mReaderManager;
                    dzVar6.lU(1);
                }
                dzVar5 = this.dpB.mReaderManager;
                dzVar5.u(dyVar.dmC, dyVar.dmE);
                return;
            }
            dzVar = this.dpB.mReaderManager;
            dzVar.a(dyVar.pbData, dyVar.isSquence, dyVar.loadType, dyVar.dmB, true);
        }
    }
}
