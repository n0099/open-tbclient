package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gn implements ei.a {
    final /* synthetic */ ReaderPbService eDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn(ReaderPbService readerPbService) {
        this.eDb = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void aRv() {
        boolean z;
        el elVar;
        el elVar2;
        el elVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.eDb.isAlive;
        if (!z) {
            elVar = this.eDb.mReaderModel;
            if (elVar != null) {
                elVar2 = this.eDb.mReaderModel;
                if (elVar2 != null) {
                    elVar3 = this.eDb.mReaderModel;
                    str = this.eDb.threadId;
                    elVar3.py(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eDb.mTagId;
        aVar.tag = bdUniqueId;
        aVar.eFN = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void aRw() {
        boolean z;
        el elVar;
        el elVar2;
        BdUniqueId bdUniqueId;
        z = this.eDb.isAlive;
        if (!z) {
            elVar = this.eDb.mReaderModel;
            if (elVar != null) {
                elVar2 = this.eDb.mReaderModel;
                elVar2.aRx();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eDb.mTagId;
        aVar.tag = bdUniqueId;
        aVar.eFN = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void bl(int i, int i2) {
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
        z = this.eDb.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.eDb.mTagId;
            aVar.tag = bdUniqueId;
            aVar.eFN = 2;
            eiVar6 = this.eDb.mReaderManager;
            aVar.eFO = eiVar6.ezP;
            eiVar7 = this.eDb.mReaderManager;
            aVar.eFP = eiVar7.aRt();
            String str2 = "";
            eiVar8 = this.eDb.mReaderManager;
            if (eiVar8.aRu() != null) {
                eiVar9 = this.eDb.mReaderManager;
                str2 = eiVar9.aRu().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        eiVar = this.eDb.mReaderManager;
        if (eiVar.aRu() != null) {
            eiVar5 = this.eDb.mReaderManager;
            str3 = eiVar5.aRu().getId();
        }
        eiVar2 = this.eDb.mReaderManager;
        boolean z2 = eiVar2.ezU;
        eiVar3 = this.eDb.mReaderManager;
        boolean z3 = eiVar3.isSquence;
        eiVar4 = this.eDb.mReaderManager;
        int i3 = eiVar4.ezP;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eDb);
        str = this.eDb.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
