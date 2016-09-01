package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ae extends CustomMessageListener {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(NewSubPbActivity newSubPbActivity, int i) {
        super(i);
        this.evy = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        ag agVar;
        ax axVar8;
        ax axVar9;
        ax axVar10;
        ax axVar11;
        ax axVar12;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                axVar = this.evy.evl;
                if (axVar.aQK() != null) {
                    axVar2 = this.evy.evl;
                    if (axVar2.aQK().aMh() != null) {
                        axVar3 = this.evy.evl;
                        if (axVar3.aQK().aMh().getAuthor() != null) {
                            axVar4 = this.evy.evl;
                            if (currentAccount.equals(axVar4.aQK().aMh().getAuthor().getUserId())) {
                                axVar5 = this.evy.evl;
                                if (axVar5.aQK().aMh().getAuthor().getPendantData() != null) {
                                    axVar6 = this.evy.evl;
                                    axVar6.aQK().aMh().getAuthor().getPendantData().cq(jVar.rc());
                                    axVar7 = this.evy.evl;
                                    axVar7.aQK().aMh().getAuthor().getPendantData().P(jVar.Cd());
                                    agVar = this.evy.evn;
                                    axVar8 = this.evy.evl;
                                    com.baidu.tieba.tbadkCore.data.q aMh = axVar8.aQK().aMh();
                                    axVar9 = this.evy.evl;
                                    boolean avC = axVar9.aQK().avC();
                                    axVar10 = this.evy.evl;
                                    boolean nv = axVar10.aQK().nv();
                                    axVar11 = this.evy.evl;
                                    int aLX = axVar11.aLX();
                                    axVar12 = this.evy.evl;
                                    agVar.a(aMh, avC, nv, aLX, axVar12.aRa() != null);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
