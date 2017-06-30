package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.fh;
/* loaded from: classes.dex */
class hq implements fh.a {
    final /* synthetic */ ReaderPbService eEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hq(ReaderPbService readerPbService) {
        this.eEB = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.fh.a
    public void aPQ() {
        boolean z;
        fk fkVar;
        fk fkVar2;
        fk fkVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.eEB.isAlive;
        if (!z) {
            fkVar = this.eEB.mReaderModel;
            if (fkVar != null) {
                fkVar2 = this.eEB.mReaderModel;
                if (fkVar2 != null) {
                    fkVar3 = this.eEB.mReaderModel;
                    str = this.eEB.threadId;
                    fkVar3.oS(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eEB.mTagId;
        aVar.tag = bdUniqueId;
        aVar.eIX = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.fh.a
    public void aPR() {
        boolean z;
        fk fkVar;
        fk fkVar2;
        BdUniqueId bdUniqueId;
        z = this.eEB.isAlive;
        if (!z) {
            fkVar = this.eEB.mReaderModel;
            if (fkVar != null) {
                fkVar2 = this.eEB.mReaderModel;
                fkVar2.aPS();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.eEB.mTagId;
        aVar.tag = bdUniqueId;
        aVar.eIX = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.fh.a
    public void bc(int i, int i2) {
        boolean z;
        fh fhVar;
        fh fhVar2;
        fh fhVar3;
        fh fhVar4;
        String str;
        fh fhVar5;
        BdUniqueId bdUniqueId;
        fh fhVar6;
        fh fhVar7;
        fh fhVar8;
        fh fhVar9;
        z = this.eEB.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.eEB.mTagId;
            aVar.tag = bdUniqueId;
            aVar.eIX = 2;
            fhVar6 = this.eEB.mReaderManager;
            aVar.eIY = fhVar6.eAL;
            fhVar7 = this.eEB.mReaderManager;
            aVar.eIZ = fhVar7.aPO();
            String str2 = "";
            fhVar8 = this.eEB.mReaderManager;
            if (fhVar8.aPP() != null) {
                fhVar9 = this.eEB.mReaderManager;
                str2 = fhVar9.aPP().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        fhVar = this.eEB.mReaderManager;
        if (fhVar.aPP() != null) {
            fhVar5 = this.eEB.mReaderManager;
            str3 = fhVar5.aPP().getId();
        }
        fhVar2 = this.eEB.mReaderManager;
        boolean z2 = fhVar2.eAQ;
        fhVar3 = this.eEB.mReaderManager;
        boolean z3 = fhVar3.isSquence;
        fhVar4 = this.eEB.mReaderManager;
        int i3 = fhVar4.eAL;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.eEB);
        str = this.eEB.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
