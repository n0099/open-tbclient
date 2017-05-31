package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ey;
/* loaded from: classes.dex */
class hf implements ey.a {
    final /* synthetic */ ReaderPbService evn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hf(ReaderPbService readerPbService) {
        this.evn = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.ey.a
    public void aLS() {
        boolean z;
        fb fbVar;
        fb fbVar2;
        fb fbVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.evn.isAlive;
        if (!z) {
            fbVar = this.evn.mReaderModel;
            if (fbVar != null) {
                fbVar2 = this.evn.mReaderModel;
                if (fbVar2 != null) {
                    fbVar3 = this.evn.mReaderModel;
                    str = this.evn.threadId;
                    fbVar3.nX(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.evn.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ezB = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ey.a
    public void aLT() {
        boolean z;
        fb fbVar;
        fb fbVar2;
        BdUniqueId bdUniqueId;
        z = this.evn.isAlive;
        if (!z) {
            fbVar = this.evn.mReaderModel;
            if (fbVar != null) {
                fbVar2 = this.evn.mReaderModel;
                fbVar2.aLU();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.evn.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ezB = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ey.a
    public void aU(int i, int i2) {
        boolean z;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        String str;
        ey eyVar5;
        BdUniqueId bdUniqueId;
        ey eyVar6;
        ey eyVar7;
        ey eyVar8;
        ey eyVar9;
        z = this.evn.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.evn.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ezB = 2;
            eyVar6 = this.evn.mReaderManager;
            aVar.ezC = eyVar6.erA;
            eyVar7 = this.evn.mReaderManager;
            aVar.ezD = eyVar7.aLQ();
            String str2 = "";
            eyVar8 = this.evn.mReaderManager;
            if (eyVar8.aLR() != null) {
                eyVar9 = this.evn.mReaderManager;
                str2 = eyVar9.aLR().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        eyVar = this.evn.mReaderManager;
        if (eyVar.aLR() != null) {
            eyVar5 = this.evn.mReaderManager;
            str3 = eyVar5.aLR().getId();
        }
        eyVar2 = this.evn.mReaderManager;
        boolean z2 = eyVar2.erF;
        eyVar3 = this.evn.mReaderManager;
        boolean z3 = eyVar3.isSquence;
        eyVar4 = this.evn.mReaderManager;
        int i3 = eyVar4.erA;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.evn);
        str = this.evn.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
