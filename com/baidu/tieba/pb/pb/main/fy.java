package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.dz;
/* loaded from: classes.dex */
class fy implements dz.a {
    final /* synthetic */ ReaderPbService dpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(ReaderPbService readerPbService) {
        this.dpB = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.dz.a
    public void ayv() {
        boolean z;
        ec ecVar;
        ec ecVar2;
        ec ecVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.dpB.isAlive;
        if (!z) {
            ecVar = this.dpB.mReaderModel;
            if (ecVar != null) {
                ecVar2 = this.dpB.mReaderModel;
                if (ecVar2 != null) {
                    ecVar3 = this.dpB.mReaderModel;
                    str = this.dpB.threadId;
                    ecVar3.lZ(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.dpB.mTagId;
        aVar.tag = bdUniqueId;
        aVar.drz = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.dz.a
    public void ayw() {
        boolean z;
        ec ecVar;
        ec ecVar2;
        BdUniqueId bdUniqueId;
        z = this.dpB.isAlive;
        if (!z) {
            ecVar = this.dpB.mReaderModel;
            if (ecVar != null) {
                ecVar2 = this.dpB.mReaderModel;
                ecVar2.ayx();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.dpB.mTagId;
        aVar.tag = bdUniqueId;
        aVar.drz = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.dz.a
    public void aM(int i, int i2) {
        boolean z;
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        dz dzVar4;
        String str;
        dz dzVar5;
        BdUniqueId bdUniqueId;
        dz dzVar6;
        dz dzVar7;
        dz dzVar8;
        dz dzVar9;
        z = this.dpB.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.dpB.mTagId;
            aVar.tag = bdUniqueId;
            aVar.drz = 2;
            dzVar6 = this.dpB.mReaderManager;
            aVar.drA = dzVar6.dmC;
            dzVar7 = this.dpB.mReaderManager;
            aVar.drB = dzVar7.ayt();
            String str2 = "";
            dzVar8 = this.dpB.mReaderManager;
            if (dzVar8.ayu() != null) {
                dzVar9 = this.dpB.mReaderManager;
                str2 = dzVar9.ayu().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        dzVar = this.dpB.mReaderManager;
        if (dzVar.ayu() != null) {
            dzVar5 = this.dpB.mReaderManager;
            str3 = dzVar5.ayu().getId();
        }
        dzVar2 = this.dpB.mReaderManager;
        boolean z2 = dzVar2.dmH;
        dzVar3 = this.dpB.mReaderManager;
        boolean z3 = dzVar3.isSquence;
        dzVar4 = this.dpB.mReaderManager;
        int i3 = dzVar4.dmC;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.dpB);
        str = this.dpB.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
