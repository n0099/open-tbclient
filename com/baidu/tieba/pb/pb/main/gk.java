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
    final /* synthetic */ ReaderPbService ewO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(ReaderPbService readerPbService) {
        this.ewO = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aPu() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        ek ekVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.ewO.isAlive;
        if (!z) {
            ekVar = this.ewO.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.ewO.mReaderModel;
                if (ekVar2 != null) {
                    ekVar3 = this.ewO.mReaderModel;
                    str = this.ewO.threadId;
                    ekVar3.pl(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.ewO.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ezc = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void aPv() {
        boolean z;
        ek ekVar;
        ek ekVar2;
        BdUniqueId bdUniqueId;
        z = this.ewO.isAlive;
        if (!z) {
            ekVar = this.ewO.mReaderModel;
            if (ekVar != null) {
                ekVar2 = this.ewO.mReaderModel;
                ekVar2.aPw();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.ewO.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ezc = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eh.a
    public void bk(int i, int i2) {
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
        z = this.ewO.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.ewO.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ezc = 2;
            ehVar6 = this.ewO.mReaderManager;
            aVar.ezd = ehVar6.ety;
            ehVar7 = this.ewO.mReaderManager;
            aVar.eze = ehVar7.aPs();
            String str2 = "";
            ehVar8 = this.ewO.mReaderManager;
            if (ehVar8.aPt() != null) {
                ehVar9 = this.ewO.mReaderManager;
                str2 = ehVar9.aPt().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ehVar = this.ewO.mReaderManager;
        if (ehVar.aPt() != null) {
            ehVar5 = this.ewO.mReaderManager;
            str3 = ehVar5.aPt().getId();
        }
        ehVar2 = this.ewO.mReaderManager;
        boolean z2 = ehVar2.etD;
        ehVar3 = this.ewO.mReaderManager;
        boolean z3 = ehVar3.isSquence;
        ehVar4 = this.ewO.mReaderManager;
        int i3 = ehVar4.ety;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ewO);
        str = this.ewO.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
