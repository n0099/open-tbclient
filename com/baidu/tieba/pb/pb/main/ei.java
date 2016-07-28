package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.eh;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei extends CustomMessageListener {
    final /* synthetic */ eh efv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eh ehVar, int i) {
        super(i);
        this.efv = ehVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        int i;
        com.baidu.tieba.pb.data.h hVar3;
        Object e;
        eh.a aVar;
        com.baidu.tieba.pb.data.h hVar4;
        eh.a aVar2;
        com.baidu.tieba.pb.data.h hVar5;
        if (customResponsedMessage != null) {
            hVar = this.efv.pbData;
            if (hVar != null) {
                this.efv.efr = false;
                hVar2 = this.efv.pbData;
                if (hVar2.aGZ() != null) {
                    hVar5 = this.efv.pbData;
                    i = hVar5.aGZ().size();
                } else {
                    i = 0;
                }
                if (this.efv.efk >= i - 3) {
                    aVar = this.efv.efs;
                    if (aVar != null) {
                        hVar4 = this.efv.pbData;
                        if (hVar4.getPage().pn() != 0) {
                            aVar2 = this.efv.efs;
                            aVar2.aJU();
                        }
                    }
                }
                if (this.efv.efk >= i - 1) {
                    this.efv.efk = -1;
                    this.efv.efo = 5;
                    com.baidu.tbadk.core.data.ba baVar = new com.baidu.tbadk.core.data.ba();
                    baVar.setData(TbadkCoreApplication.m10getInst().getResources().getString(u.j.read_thread_over));
                    baVar.bF(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar));
                    return;
                } else if (this.efv.efk == -1) {
                    this.efv.efo = 5;
                    this.efv.efk = 0;
                    com.baidu.tbadk.core.data.ba baVar2 = new com.baidu.tbadk.core.data.ba();
                    baVar2.bF(15);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar2));
                    return;
                } else {
                    this.efv.efk++;
                    this.efv.efo = 1;
                    eh ehVar = this.efv;
                    int i2 = this.efv.efk;
                    hVar3 = this.efv.pbData;
                    e = ehVar.e(i2, hVar3.aGZ());
                    com.baidu.tbadk.core.data.ba baVar3 = new com.baidu.tbadk.core.data.ba();
                    baVar3.bF(1);
                    baVar3.setData(e);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TTS_OPTION, baVar3));
                    return;
                }
            }
            this.efv.efo = 5;
            this.efv.efk = 0;
        }
    }
}
