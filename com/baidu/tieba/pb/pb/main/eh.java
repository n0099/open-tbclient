package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eg;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eh extends CustomMessageListener {
    final /* synthetic */ eg dTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh(eg egVar, int i) {
        super(i);
        this.dTe = egVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        int i;
        com.baidu.tieba.pb.data.h hVar3;
        Object e;
        eg.a aVar;
        com.baidu.tieba.pb.data.h hVar4;
        eg.a aVar2;
        com.baidu.tieba.pb.data.h hVar5;
        if (customResponsedMessage != null) {
            hVar = this.dTe.pbData;
            if (hVar != null) {
                this.dTe.dTa = false;
                hVar2 = this.dTe.pbData;
                if (hVar2.aDP() != null) {
                    hVar5 = this.dTe.pbData;
                    i = hVar5.aDP().size();
                } else {
                    i = 0;
                }
                if (this.dTe.dST >= i - 3) {
                    aVar = this.dTe.dTb;
                    if (aVar != null) {
                        hVar4 = this.dTe.pbData;
                        if (hVar4.getPage().pE() != 0) {
                            aVar2 = this.dTe.dTb;
                            aVar2.aGH();
                        }
                    }
                }
                if (this.dTe.dST >= i - 1) {
                    this.dTe.dST = -1;
                    this.dTe.dSX = 5;
                    com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
                    avVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(u.j.read_thread_over));
                    avVar.bG(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar));
                    return;
                } else if (this.dTe.dST == -1) {
                    this.dTe.dSX = 5;
                    this.dTe.dST = 0;
                    com.baidu.tbadk.core.data.av avVar2 = new com.baidu.tbadk.core.data.av();
                    avVar2.bG(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar2));
                    return;
                } else {
                    this.dTe.dST++;
                    this.dTe.dSX = 1;
                    eg egVar = this.dTe;
                    int i2 = this.dTe.dST;
                    hVar3 = this.dTe.pbData;
                    e = egVar.e(i2, hVar3.aDP());
                    com.baidu.tbadk.core.data.av avVar3 = new com.baidu.tbadk.core.data.av();
                    avVar3.bG(1);
                    avVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, avVar3));
                    return;
                }
            }
            this.dTe.dSX = 5;
            this.dTe.dST = 0;
        }
    }
}
