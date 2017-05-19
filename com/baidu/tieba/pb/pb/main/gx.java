package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ep;
/* loaded from: classes.dex */
class gx implements ep.a {
    final /* synthetic */ ReaderPbService epy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(ReaderPbService readerPbService) {
        this.epy = readerPbService;
    }

    @Override // com.baidu.tieba.pb.pb.main.ep.a
    public void aKW() {
        boolean z;
        es esVar;
        es esVar2;
        es esVar3;
        String str;
        BdUniqueId bdUniqueId;
        z = this.epy.isAlive;
        if (!z) {
            esVar = this.epy.mReaderModel;
            if (esVar != null) {
                esVar2 = this.epy.mReaderModel;
                if (esVar2 != null) {
                    esVar3 = this.epy.mReaderModel;
                    str = this.epy.threadId;
                    esVar3.nL(str);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.epy.mTagId;
        aVar.tag = bdUniqueId;
        aVar.esp = 0;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ep.a
    public void aKX() {
        boolean z;
        es esVar;
        es esVar2;
        BdUniqueId bdUniqueId;
        z = this.epy.isAlive;
        if (!z) {
            esVar = this.epy.mReaderModel;
            if (esVar != null) {
                esVar2 = this.epy.mReaderModel;
                esVar2.aKY();
                return;
            }
            return;
        }
        com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
        bdUniqueId = this.epy.mTagId;
        aVar.tag = bdUniqueId;
        aVar.esp = 1;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
    }

    @Override // com.baidu.tieba.pb.pb.main.ep.a
    public void aW(int i, int i2) {
        boolean z;
        ep epVar;
        ep epVar2;
        ep epVar3;
        ep epVar4;
        String str;
        ep epVar5;
        BdUniqueId bdUniqueId;
        ep epVar6;
        ep epVar7;
        ep epVar8;
        ep epVar9;
        z = this.epy.isAlive;
        if (z) {
            com.baidu.tieba.pb.b.a aVar = new com.baidu.tieba.pb.b.a();
            bdUniqueId = this.epy.mTagId;
            aVar.tag = bdUniqueId;
            aVar.esp = 2;
            epVar6 = this.epy.mReaderManager;
            aVar.esq = epVar6.elN;
            epVar7 = this.epy.mReaderManager;
            aVar.esr = epVar7.aKU();
            String str2 = "";
            epVar8 = this.epy.mReaderManager;
            if (epVar8.aKV() != null) {
                epVar9 = this.epy.mReaderManager;
                str2 = epVar9.aKV().getId();
            }
            aVar.postId = str2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION_PB, aVar));
            return;
        }
        String str3 = "";
        epVar = this.epy.mReaderManager;
        if (epVar.aKV() != null) {
            epVar5 = this.epy.mReaderManager;
            str3 = epVar5.aKV().getId();
        }
        epVar2 = this.epy.mReaderManager;
        boolean z2 = epVar2.elS;
        epVar3 = this.epy.mReaderManager;
        boolean z3 = epVar3.isSquence;
        epVar4 = this.epy.mReaderManager;
        int i3 = epVar4.elN;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.epy);
        str = this.epy.threadId;
        pbActivityConfig.createReaderServiceCfg(str, str3, i3, z2, z3, null);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
    }
}
