package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class hp extends CustomMessageListener {
    final /* synthetic */ ReaderPbService eEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hp(ReaderPbService readerPbService, int i) {
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
        fh fhVar6;
        BdUniqueId bdUniqueId;
        fk fkVar;
        BdUniqueId bdUniqueId2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof fg)) {
            fg fgVar = (fg) customResponsedMessage.getData();
            BdUniqueId bdUniqueId3 = fgVar.tag;
            if (bdUniqueId3 != null) {
                bdUniqueId = this.eEB.mTagId;
                if (bdUniqueId.getId() != bdUniqueId3.getId()) {
                    this.eEB.mTagId = bdUniqueId3;
                    fkVar = this.eEB.mReaderModel;
                    bdUniqueId2 = this.eEB.mTagId;
                    fkVar.n(bdUniqueId2);
                }
            }
            this.eEB.threadId = fgVar.threadId;
            this.eEB.postId = fgVar.postId;
            this.eEB.isAlive = fgVar.isAlive;
            this.eEB.setReadModel(fgVar);
            if (fgVar.eAL >= 0) {
                fhVar2 = this.eEB.mReaderManager;
                fhVar2.a(fgVar.pbData, fgVar.isSquence, fgVar.loadType, fgVar.eAK, false);
                fhVar3 = this.eEB.mReaderManager;
                int aPN = fhVar3.aPN();
                if (aPN == 1 || aPN == 3) {
                    fhVar4 = this.eEB.mReaderManager;
                    fhVar4.oX(0);
                } else {
                    fhVar6 = this.eEB.mReaderManager;
                    fhVar6.oX(1);
                }
                fhVar5 = this.eEB.mReaderManager;
                fhVar5.z(fgVar.eAL, fgVar.eAN);
                return;
            }
            fhVar = this.eEB.mReaderManager;
            fhVar.a(fgVar.pbData, fgVar.isSquence, fgVar.loadType, fgVar.eAK, true);
        }
    }
}
