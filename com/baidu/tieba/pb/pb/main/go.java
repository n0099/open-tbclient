package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class go implements eh.a {
    final /* synthetic */ ReaderPbService etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(ReaderPbService readerPbService) {
        this.etX = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aNG() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        ek ekVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.etX.isAlive;
        if (!z) {
            ekVar = this.etX.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.etX.mReaderModel;
                if (ekVar2 != null) {
                    ekVar3 = this.etX.mReaderModel;
                    str = this.etX.threadId;
                    ekVar3.nE(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.etX.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ewG = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aNH() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        BdUniqueId bdUniqueId;
        z = this.etX.isAlive;
        if (!z) {
            ekVar = this.etX.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.etX.mReaderModel;
                ekVar2.aNI();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.etX.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ewG = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aZ(int i, int i2) {
        boolean z;
        eh ehVar;
        eh ehVar2;
        eh ehVar3;
        eh ehVar4;
        String str;
        eh ehVar5;
        BdUniqueId bdUniqueId;
        eh ehVar6;
        eh ehVar7;
        eh ehVar8;
        eh ehVar9;
        z = this.etX.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.etX.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ewG = 2;
            ehVar6 = this.etX.mReaderManager;
            aVar.ewH = ehVar6.eqs;
            ehVar7 = this.etX.mReaderManager;
            aVar.ewI = ehVar7.aNE();
            String str2 = "";
            ehVar8 = this.etX.mReaderManager;
            if (ehVar8.aNF() != null) {
                ehVar9 = this.etX.mReaderManager;
                str2 = ehVar9.aNF().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ehVar = this.etX.mReaderManager;
        if (ehVar.aNF() != null) {
            ehVar5 = this.etX.mReaderManager;
            str3 = ehVar5.aNF().getId();
        }
        ehVar2 = this.etX.mReaderManager;
        boolean z2 = ehVar2.eqx;
        ehVar3 = this.etX.mReaderManager;
        boolean z3 = ehVar3.isSquence;
        ehVar4 = this.etX.mReaderManager;
        int i3 = ehVar4.eqs;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.etX);
        str = this.etX.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
