package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gk implements eh.a {
    final /* synthetic */ ReaderPbService euI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(ReaderPbService readerPbService) {
        this.euI = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aOL() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        ek ekVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.euI.isAlive;
        if (!z) {
            ekVar = this.euI.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.euI.mReaderModel;
                if (ekVar2 != null) {
                    ekVar3 = this.euI.mReaderModel;
                    str = this.euI.threadId;
                    ekVar3.oW(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.euI.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ewU = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aOM() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        BdUniqueId bdUniqueId;
        z = this.euI.isAlive;
        if (!z) {
            ekVar = this.euI.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.euI.mReaderModel;
                ekVar2.aON();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.euI.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ewU = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void bi(int i, int i2) {
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
        z = this.euI.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.euI.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ewU = 2;
            ehVar6 = this.euI.mReaderManager;
            aVar.ewV = ehVar6.erp;
            ehVar7 = this.euI.mReaderManager;
            aVar.ewW = ehVar7.aOJ();
            String str2 = "";
            ehVar8 = this.euI.mReaderManager;
            if (ehVar8.aOK() != null) {
                ehVar9 = this.euI.mReaderManager;
                str2 = ehVar9.aOK().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ehVar = this.euI.mReaderManager;
        if (ehVar.aOK() != null) {
            ehVar5 = this.euI.mReaderManager;
            str3 = ehVar5.aOK().getId();
        }
        ehVar2 = this.euI.mReaderManager;
        boolean z2 = ehVar2.eru;
        ehVar3 = this.euI.mReaderManager;
        boolean z3 = ehVar3.isSquence;
        ehVar4 = this.euI.mReaderManager;
        int i3 = ehVar4.erp;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.euI);
        str = this.euI.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
