package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eb;
/* loaded from: classes.dex */
class gg implements eb.a {
    final /* synthetic */ ReaderPbService ehh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(ReaderPbService readerPbService) {
        this.ehh = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.eb.a
    public void aLp() {
        boolean z;
        ee eeVar;
        ee eeVar2;
        ee eeVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.ehh.isAlive;
        if (!z) {
            eeVar = this.ehh.mReaderModel;
            if (eeVar != null) {
                eeVar2 = this.ehh.mReaderModel;
                if (eeVar2 != null) {
                    eeVar3 = this.ehh.mReaderModel;
                    str = this.ehh.threadId;
                    eeVar3.nZ(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.ehh.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ejN = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eb.a
    public void aLq() {
        boolean z;
        ee eeVar;
        ee eeVar2;
        BdUniqueId bdUniqueId;
        z = this.ehh.isAlive;
        if (!z) {
            eeVar = this.ehh.mReaderModel;
            if (eeVar != null) {
                eeVar2 = this.ehh.mReaderModel;
                eeVar2.aLr();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.ehh.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ejN = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.eb.a
    public void ba(int i, int i2) {
        boolean z;
        eb ebVar;
        eb ebVar2;
        eb ebVar3;
        eb ebVar4;
        String str;
        eb ebVar5;
        BdUniqueId bdUniqueId;
        eb ebVar6;
        eb ebVar7;
        eb ebVar8;
        eb ebVar9;
        z = this.ehh.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.ehh.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ejN = 2;
            ebVar6 = this.ehh.mReaderManager;
            aVar.ejO = ebVar6.edY;
            ebVar7 = this.ehh.mReaderManager;
            aVar.ejP = ebVar7.aLn();
            String str2 = "";
            ebVar8 = this.ehh.mReaderManager;
            if (ebVar8.aLo() != null) {
                ebVar9 = this.ehh.mReaderManager;
                str2 = ebVar9.aLo().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ebVar = this.ehh.mReaderManager;
        if (ebVar.aLo() != null) {
            ebVar5 = this.ehh.mReaderManager;
            str3 = ebVar5.aLo().getId();
        }
        ebVar2 = this.ehh.mReaderManager;
        boolean z2 = ebVar2.eed;
        ebVar3 = this.ehh.mReaderManager;
        boolean z3 = ebVar3.isSquence;
        ebVar4 = this.ehh.mReaderManager;
        int i3 = ebVar4.edY;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.ehh);
        str = this.ehh.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
