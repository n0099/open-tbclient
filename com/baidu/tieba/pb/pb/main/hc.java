package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ey;
/* loaded from: classes.dex */
class hc extends CustomMessageListener {
    final /* synthetic */ ReaderPbService evn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hc(ReaderPbService readerPbService, int i) {
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
        BdUniqueId bdUniqueId;
        fb fbVar;
        BdUniqueId bdUniqueId2;
        ey eyVar6;
        ey.a aVar;
        fb fbVar2;
        PbModel.a aVar2;
        BdUniqueId bdUniqueId3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ex)) {
            ex exVar = (ex) customResponsedMessage.getData();
            BdUniqueId bdUniqueId4 = exVar.tag;
            if (bdUniqueId4 != null) {
                bdUniqueId = this.evn.mTagId;
                if (bdUniqueId.getId() != bdUniqueId4.getId()) {
                    this.evn.releasePbReaderModel();
                    this.evn.releaseReadManager();
                    this.evn.mTagId = bdUniqueId4;
                    this.evn.mReaderManager = new ey();
                    this.evn.mReaderModel = new fb();
                    fbVar = this.evn.mReaderModel;
                    bdUniqueId2 = this.evn.mTagId;
                    fbVar.n(bdUniqueId2);
                    eyVar6 = this.evn.mReaderManager;
                    aVar = this.evn.mRefreshCallback;
                    eyVar6.a(aVar);
                    fbVar2 = this.evn.mReaderModel;
                    aVar2 = this.evn.mLoadDataCallback;
                    fbVar2.b(aVar2);
                    bdUniqueId3 = this.evn.mTagId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_READER_TAG_CHANGED, bdUniqueId3));
                }
            }
            this.evn.threadId = exVar.threadId;
            this.evn.postId = exVar.postId;
            this.evn.isAlive = exVar.isAlive;
            this.evn.setReadModel(exVar);
            if (exVar.erA >= 0) {
                eyVar3 = this.evn.mReaderManager;
                eyVar3.b(exVar.pbData, exVar.isSquence, exVar.loadType, exVar.erz);
                eyVar4 = this.evn.mReaderManager;
                eyVar4.erB = exVar.erB;
                eyVar5 = this.evn.mReaderManager;
                eyVar5.z(exVar.erA, exVar.erC);
            } else if (exVar.erA == -2) {
                eyVar2 = this.evn.mReaderManager;
                eyVar2.a(exVar.pbData, exVar.isSquence, exVar.loadType, exVar.erz, false);
            } else {
                eyVar = this.evn.mReaderManager;
                eyVar.b(exVar.pbData, exVar.isSquence, exVar.loadType, exVar.erz);
            }
        }
    }
}
