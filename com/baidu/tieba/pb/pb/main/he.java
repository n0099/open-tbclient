package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class he extends CustomMessageListener {
    final /* synthetic */ ReaderPbService evn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he(ReaderPbService readerPbService, int i) {
        super(i);
        this.evn = readerPbService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        ey eyVar5;
        ey eyVar6;
        BdUniqueId bdUniqueId;
        fb fbVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ex)) {
            ex exVar = (ex) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = exVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.evn.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.evn.mTagId = bdUniqueId3;
                    fbVar = this.evn.mReaderModel;
                    bdUniqueId2 = this.evn.mTagId;
                    fbVar.n(bdUniqueId2);
                }
            }
            this.evn.threadId = exVar.threadId;
            this.evn.postId = exVar.postId;
            this.evn.isAlive = exVar.isAlive;
            this.evn.setReadModel(exVar);
            if (exVar.erA >= 0) {
                eyVar2 = this.evn.mReaderManager;
                eyVar2.a(exVar.pbData, exVar.isSquence, exVar.loadType, exVar.erz, false);
                eyVar3 = this.evn.mReaderManager;
                int aLP = eyVar3.aLP();
                if (aLP == 1 || aLP == 3) {
                    eyVar4 = this.evn.mReaderManager;
                    eyVar4.oG(0);
                } else {
                    eyVar6 = this.evn.mReaderManager;
                    eyVar6.oG(1);
                }
                eyVar5 = this.evn.mReaderManager;
                eyVar5.z(exVar.erA, exVar.erC);
                return;
            }
            eyVar = this.evn.mReaderManager;
            eyVar.a(exVar.pbData, exVar.isSquence, exVar.loadType, exVar.erz, true);
        }
    }
}
