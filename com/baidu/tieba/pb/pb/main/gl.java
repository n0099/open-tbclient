package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ei;
/* loaded from: classes.dex */
class gl implements ei.a {
    final /* synthetic */ ReaderPbService dnu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(ReaderPbService readerPbService) {
        this.dnu = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void axW() {
        boolean z;
        el elVar;
        el elVar2;
        el elVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.dnu.isAlive;
        if (!z) {
            elVar = this.dnu.mReaderModel;
            if (elVar != null) {
                elVar2 = this.dnu.mReaderModel;
                if (elVar2 != null) {
                    elVar3 = this.dnu.mReaderModel;
                    str = this.dnu.threadId;
                    elVar3.lZ(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.dnu.mTagId;
        aVar.tag = bdUniqueId;
        aVar.dpQ = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void axX() {
        boolean z;
        el elVar;
        el elVar2;
        BdUniqueId bdUniqueId;
        z = this.dnu.isAlive;
        if (!z) {
            elVar = this.dnu.mReaderModel;
            if (elVar != null) {
                elVar2 = this.dnu.mReaderModel;
                elVar2.axY();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.dnu.mTagId;
        aVar.tag = bdUniqueId;
        aVar.dpQ = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ei.a
    public void aM(int i, int i2) {
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
        z = this.dnu.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.dnu.mTagId;
            aVar.tag = bdUniqueId;
            aVar.dpQ = 2;
            eiVar6 = this.dnu.mReaderManager;
            aVar.dpR = eiVar6.axS();
            eiVar7 = this.dnu.mReaderManager;
            aVar.dpS = eiVar7.axU();
            String str2 = "";
            eiVar8 = this.dnu.mReaderManager;
            if (eiVar8.axV() != null) {
                eiVar9 = this.dnu.mReaderManager;
                str2 = eiVar9.axV().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        eiVar = this.dnu.mReaderManager;
        if (eiVar.axV() != null) {
            eiVar5 = this.dnu.mReaderManager;
            str3 = eiVar5.axV().getId();
        }
        eiVar2 = this.dnu.mReaderManager;
        boolean axT = eiVar2.axT();
        eiVar3 = this.dnu.mReaderManager;
        boolean auq = eiVar3.auq();
        eiVar4 = this.dnu.mReaderManager;
        int axS = eiVar4.axS();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dnu);
        str = this.dnu.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, axS, axT, auq, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
