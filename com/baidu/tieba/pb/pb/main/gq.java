package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gq implements ei.a {
    final /* synthetic */ ReaderPbService eqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gq(ReaderPbService readerPbService) {
        this.eqq = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void aNd() {
        boolean z;
        el elVar;
        el elVar2;
        el elVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.eqq.isAlive;
        if (!z) {
            elVar = this.eqq.mReaderModel;
            if (elVar != null) {
                elVar2 = this.eqq.mReaderModel;
                if (elVar2 != null) {
                    elVar3 = this.eqq.mReaderModel;
                    str = this.eqq.threadId;
                    elVar3.oq(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eqq.mTagId;
        aVar.tag = bdUniqueId;
        aVar.esX = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void aNe() {
        boolean z;
        el elVar;
        el elVar2;
        BdUniqueId bdUniqueId;
        z = this.eqq.isAlive;
        if (!z) {
            elVar = this.eqq.mReaderModel;
            if (elVar != null) {
                elVar2 = this.eqq.mReaderModel;
                elVar2.aNf();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eqq.mTagId;
        aVar.tag = bdUniqueId;
        aVar.esX = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void bb(int i, int i2) {
        boolean z;
        ei eiVar;
        ei eiVar2;
        ei eiVar3;
        ei eiVar4;
        String str;
        ei eiVar5;
        BdUniqueId bdUniqueId;
        ei eiVar6;
        ei eiVar7;
        ei eiVar8;
        ei eiVar9;
        z = this.eqq.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.eqq.mTagId;
            aVar.tag = bdUniqueId;
            aVar.esX = 2;
            eiVar6 = this.eqq.mReaderManager;
            aVar.esY = eiVar6.emS;
            eiVar7 = this.eqq.mReaderManager;
            aVar.esZ = eiVar7.aNb();
            String str2 = "";
            eiVar8 = this.eqq.mReaderManager;
            if (eiVar8.aNc() != null) {
                eiVar9 = this.eqq.mReaderManager;
                str2 = eiVar9.aNc().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        eiVar = this.eqq.mReaderManager;
        if (eiVar.aNc() != null) {
            eiVar5 = this.eqq.mReaderManager;
            str3 = eiVar5.aNc().getId();
        }
        eiVar2 = this.eqq.mReaderManager;
        boolean z2 = eiVar2.emX;
        eiVar3 = this.eqq.mReaderManager;
        boolean z3 = eiVar3.isSquence;
        eiVar4 = this.eqq.mReaderManager;
        int i3 = eiVar4.emS;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eqq);
        str = this.eqq.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
