package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.ei;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej extends CustomMessageListener {
    final /* synthetic */ ei eAa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(ei eiVar, int i) {
        super(i);
        this.eAa = eiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        int i;
        com.baidu.tieba.pb.data.h hVar3;
        Object e;
        ei.a aVar;
        com.baidu.tieba.pb.data.h hVar4;
        ei.a aVar2;
        com.baidu.tieba.pb.data.h hVar5;
        if (customResponsedMessage != null) {
            hVar = this.eAa.pbData;
            if (hVar != null) {
                this.eAa.ezW = false;
                hVar2 = this.eAa.pbData;
                if (hVar2.aOm() != null) {
                    hVar5 = this.eAa.pbData;
                    i = hVar5.aOm().size();
                } else {
                    i = 0;
                }
                if (this.eAa.ezP >= i - 3) {
                    aVar = this.eAa.ezX;
                    if (aVar != null) {
                        hVar4 = this.eAa.pbData;
                        if (hVar4.getPage().qD() != 0) {
                            aVar2 = this.eAa.ezX;
                            aVar2.aRv();
                        }
                    }
                }
                if (this.eAa.ezP >= i - 1) {
                    this.eAa.ezP = -1;
                    this.eAa.ezT = 5;
                    com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                    bgVar.setData(TbadkCoreApplication.m9getInst().getResources().getString(r.j.read_thread_over));
                    bgVar.bS(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar));
                    return;
                } else if (this.eAa.ezP == -1) {
                    this.eAa.ezT = 5;
                    this.eAa.ezP = 0;
                    com.baidu.tbadk.core.data.bg bgVar2 = new com.baidu.tbadk.core.data.bg();
                    bgVar2.bS(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar2));
                    return;
                } else {
                    this.eAa.ezP++;
                    this.eAa.ezT = 1;
                    ei eiVar = this.eAa;
                    int i2 = this.eAa.ezP;
                    hVar3 = this.eAa.pbData;
                    e = eiVar.e(i2, hVar3.aOm());
                    com.baidu.tbadk.core.data.bg bgVar3 = new com.baidu.tbadk.core.data.bg();
                    bgVar3.bS(1);
                    bgVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, bgVar3));
                    return;
                }
            }
            this.eAa.ezT = 5;
            this.eAa.ezP = 0;
        }
    }
}
