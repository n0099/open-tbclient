package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ej;
/* loaded from: classes.dex */
class gq implements ej.a {
    final /* synthetic */ ReaderPbService etx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gq(ReaderPbService readerPbService) {
        this.etx = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.ej.a
    public void aMw() {
        boolean z;
        em emVar;
        em emVar2;
        em emVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.etx.isAlive;
        if (!z) {
            emVar = this.etx.mReaderModel;
            if (emVar != null) {
                emVar2 = this.etx.mReaderModel;
                if (emVar2 != null) {
                    emVar3 = this.etx.mReaderModel;
                    str = this.etx.threadId;
                    emVar3.nx(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.etx.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ewl = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ej.a
    public void aMx() {
        boolean z;
        em emVar;
        em emVar2;
        BdUniqueId bdUniqueId;
        z = this.etx.isAlive;
        if (!z) {
            emVar = this.etx.mReaderModel;
            if (emVar != null) {
                emVar2 = this.etx.mReaderModel;
                emVar2.aMy();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.etx.mTagId;
        aVar.tag = bdUniqueId;
        aVar.ewl = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ej.a
    public void bf(int i, int i2) {
        boolean z;
        ej ejVar;
        ej ejVar2;
        ej ejVar3;
        ej ejVar4;
        String str;
        ej ejVar5;
        BdUniqueId bdUniqueId;
        ej ejVar6;
        ej ejVar7;
        ej ejVar8;
        ej ejVar9;
        z = this.etx.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.etx.mTagId;
            aVar.tag = bdUniqueId;
            aVar.ewl = 2;
            ejVar6 = this.etx.mReaderManager;
            aVar.ewm = ejVar6.epS;
            ejVar7 = this.etx.mReaderManager;
            aVar.ewn = ejVar7.aMu();
            String str2 = "";
            ejVar8 = this.etx.mReaderManager;
            if (ejVar8.aMv() != null) {
                ejVar9 = this.etx.mReaderManager;
                str2 = ejVar9.aMv().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        ejVar = this.etx.mReaderManager;
        if (ejVar.aMv() != null) {
            ejVar5 = this.etx.mReaderManager;
            str3 = ejVar5.aMv().getId();
        }
        ejVar2 = this.etx.mReaderManager;
        boolean z2 = ejVar2.epX;
        ejVar3 = this.etx.mReaderManager;
        boolean z3 = ejVar3.isSquence;
        ejVar4 = this.etx.mReaderManager;
        int i3 = ejVar4.epS;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.etx);
        str = this.etx.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
