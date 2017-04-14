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
    final /* synthetic */ ReaderPbService erF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(ReaderPbService readerPbService) {
        this.erF = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aMF() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        ek ekVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.erF.isAlive;
        if (!z) {
            ekVar = this.erF.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.erF.mReaderModel;
                if (ekVar2 != null) {
                    ekVar3 = this.erF.mReaderModel;
                    str = this.erF.threadId;
                    ekVar3.nD(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.erF.mTagId;
        aVar.tag = bdUniqueId;
        aVar.euq = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aMG() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        BdUniqueId bdUniqueId;
        z = this.erF.isAlive;
        if (!z) {
            ekVar = this.erF.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.erF.mReaderModel;
                ekVar2.aMH();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.erF.mTagId;
        aVar.tag = bdUniqueId;
        aVar.euq = 1;
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
        z = this.erF.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.erF.mTagId;
            aVar.tag = bdUniqueId;
            aVar.euq = 2;
            ehVar6 = this.erF.mReaderManager;
            aVar.eur = ehVar6.eoa;
            ehVar7 = this.erF.mReaderManager;
            aVar.eus = ehVar7.aMD();
            String str2 = "";
            ehVar8 = this.erF.mReaderManager;
            if (ehVar8.aME() != null) {
                ehVar9 = this.erF.mReaderManager;
                str2 = ehVar9.aME().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ehVar = this.erF.mReaderManager;
        if (ehVar.aME() != null) {
            ehVar5 = this.erF.mReaderManager;
            str3 = ehVar5.aME().getId();
        }
        ehVar2 = this.erF.mReaderManager;
        boolean z2 = ehVar2.eog;
        ehVar3 = this.erF.mReaderManager;
        boolean z3 = ehVar3.isSquence;
        ehVar4 = this.erF.mReaderManager;
        int i3 = ehVar4.eoa;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.erF);
        str = this.erF.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
