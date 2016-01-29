package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dn;
/* loaded from: classes.dex */
class fk implements dn.a {
    final /* synthetic */ ReaderPbService cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(ReaderPbService readerPbService) {
        this.cSC = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.dn.a
    public void aqG() {
        boolean z;
        dq dqVar;
        dq dqVar2;
        dq dqVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.cSC.isAlive;
        if (!z) {
            dqVar = this.cSC.mReaderModel;
            if (dqVar != null) {
                dqVar2 = this.cSC.mReaderModel;
                if (dqVar2 != null) {
                    dqVar3 = this.cSC.mReaderModel;
                    str = this.cSC.threadId;
                    dqVar3.kM(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.c.a aVar = new com.baidu.tieba.pb.c.a();
        bdUniqueId = this.cSC.mTagId;
        aVar.tag = bdUniqueId;
        aVar.cUV = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.dn.a
    public void aqH() {
        boolean z;
        dq dqVar;
        dq dqVar2;
        BdUniqueId bdUniqueId;
        z = this.cSC.isAlive;
        if (!z) {
            dqVar = this.cSC.mReaderModel;
            if (dqVar != null) {
                dqVar2 = this.cSC.mReaderModel;
                dqVar2.aqI();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.c.a aVar = new com.baidu.tieba.pb.c.a();
        bdUniqueId = this.cSC.mTagId;
        aVar.tag = bdUniqueId;
        aVar.cUV = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.dn.a
    public void aM(int i, int i2) {
        boolean z;
        dn dnVar;
        dn dnVar2;
        dn dnVar3;
        dn dnVar4;
        String str;
        dn dnVar5;
        BdUniqueId bdUniqueId;
        dn dnVar6;
        dn dnVar7;
        dn dnVar8;
        dn dnVar9;
        z = this.cSC.isAlive;
        if (z) {
            com.baidu.tieba.pb.c.a aVar = new com.baidu.tieba.pb.c.a();
            bdUniqueId = this.cSC.mTagId;
            aVar.tag = bdUniqueId;
            aVar.cUV = 2;
            dnVar6 = this.cSC.mReaderManager;
            aVar.cUW = dnVar6.aqC();
            dnVar7 = this.cSC.mReaderManager;
            aVar.cUX = dnVar7.aqE();
            String str2 = "";
            dnVar8 = this.cSC.mReaderManager;
            if (dnVar8.aqF() != null) {
                dnVar9 = this.cSC.mReaderManager;
                str2 = dnVar9.aqF().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        dnVar = this.cSC.mReaderManager;
        if (dnVar.aqF() != null) {
            dnVar5 = this.cSC.mReaderManager;
            str3 = dnVar5.aqF().getId();
        }
        dnVar2 = this.cSC.mReaderManager;
        boolean aqD = dnVar2.aqD();
        dnVar3 = this.cSC.mReaderManager;
        boolean anx = dnVar3.anx();
        dnVar4 = this.cSC.mReaderManager;
        int aqC = dnVar4.aqC();
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.cSC);
        str = this.cSC.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, aqC, aqD, anx, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
