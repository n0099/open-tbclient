package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eg;
/* loaded from: classes.dex */
class gf implements eg.a {
    final /* synthetic */ ReaderPbService dVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gf(ReaderPbService readerPbService) {
        this.dVY = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eg.a
    public void aGH() {
        boolean z;
        ej ejVar;
        ej ejVar2;
        ej ejVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.dVY.isAlive;
        if (!z) {
            ejVar = this.dVY.mReaderModel;
            if (ejVar != null) {
                ejVar2 = this.dVY.mReaderModel;
                if (ejVar2 != null) {
                    ejVar3 = this.dVY.mReaderModel;
                    str = this.dVY.threadId;
                    ejVar3.nA(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.dVY.mTagId;
        aVar.tag = bdUniqueId;
        aVar.dYk = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eg.a
    public void aGI() {
        boolean z;
        ej ejVar;
        ej ejVar2;
        BdUniqueId bdUniqueId;
        z = this.dVY.isAlive;
        if (!z) {
            ejVar = this.dVY.mReaderModel;
            if (ejVar != null) {
                ejVar2 = this.dVY.mReaderModel;
                ejVar2.aGJ();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.dVY.mTagId;
        aVar.tag = bdUniqueId;
        aVar.dYk = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eg.a
    public void bb(int i, int i2) {
        boolean z;
        eg egVar;
        eg egVar2;
        eg egVar3;
        eg egVar4;
        String str;
        eg egVar5;
        BdUniqueId bdUniqueId;
        eg egVar6;
        eg egVar7;
        eg egVar8;
        eg egVar9;
        z = this.dVY.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.dVY.mTagId;
            aVar.tag = bdUniqueId;
            aVar.dYk = 2;
            egVar6 = this.dVY.mReaderManager;
            aVar.dYl = egVar6.dST;
            egVar7 = this.dVY.mReaderManager;
            aVar.dYm = egVar7.aGF();
            String str2 = "";
            egVar8 = this.dVY.mReaderManager;
            if (egVar8.aGG() != null) {
                egVar9 = this.dVY.mReaderManager;
                str2 = egVar9.aGG().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        egVar = this.dVY.mReaderManager;
        if (egVar.aGG() != null) {
            egVar5 = this.dVY.mReaderManager;
            str3 = egVar5.aGG().getId();
        }
        egVar2 = this.dVY.mReaderManager;
        boolean z2 = egVar2.dSY;
        egVar3 = this.dVY.mReaderManager;
        boolean z3 = egVar3.isSquence;
        egVar4 = this.dVY.mReaderManager;
        int i3 = egVar4.dST;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dVY);
        str = this.dVY.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
