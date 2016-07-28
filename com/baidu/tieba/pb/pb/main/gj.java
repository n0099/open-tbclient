package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
/* loaded from: classes.dex */
class gj implements eh.a {
    final /* synthetic */ ReaderPbService eiB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj(ReaderPbService readerPbService) {
        this.eiB = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aJU() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        ek ekVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.eiB.isAlive;
        if (!z) {
            ekVar = this.eiB.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.eiB.mReaderModel;
                if (ekVar2 != null) {
                    ekVar3 = this.eiB.mReaderModel;
                    str = this.eiB.threadId;
                    ekVar3.on(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eiB.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ekM = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aJV() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        BdUniqueId bdUniqueId;
        z = this.eiB.isAlive;
        if (!z) {
            ekVar = this.eiB.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.eiB.mReaderModel;
                ekVar2.aJW();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eiB.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ekM = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void be(int i, int i2) {
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
        z = this.eiB.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.eiB.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ekM = 2;
            ehVar6 = this.eiB.mReaderManager;
            aVar.ekN = ehVar6.efk;
            ehVar7 = this.eiB.mReaderManager;
            aVar.ekO = ehVar7.aJS();
            String str2 = "";
            ehVar8 = this.eiB.mReaderManager;
            if (ehVar8.aJT() != null) {
                ehVar9 = this.eiB.mReaderManager;
                str2 = ehVar9.aJT().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ehVar = this.eiB.mReaderManager;
        if (ehVar.aJT() != null) {
            ehVar5 = this.eiB.mReaderManager;
            str3 = ehVar5.aJT().getId();
        }
        ehVar2 = this.eiB.mReaderManager;
        boolean z2 = ehVar2.efp;
        ehVar3 = this.eiB.mReaderManager;
        boolean z3 = ehVar3.isSquence;
        ehVar4 = this.eiB.mReaderManager;
        int i3 = ehVar4.efk;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eiB);
        str = this.eiB.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
