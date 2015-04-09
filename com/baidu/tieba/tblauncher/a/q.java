package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p csD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.csD = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a aVar;
        boolean aoR;
        boolean aoS;
        boolean aoT;
        boolean aoU;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        a aVar9;
        a aVar10;
        if (customResponsedMessage != null && (customResponsedMessage instanceof LeftNaviScanMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.message.a)) {
            ArrayList arrayList = new ArrayList();
            p pVar = this.csD;
            aVar = this.csD.csB;
            pVar.b(aVar, arrayList);
            aoR = this.csD.aoR();
            if (aoR) {
                aVar9 = this.csD.csx;
                if (aVar9 != null) {
                    p pVar2 = this.csD;
                    aVar10 = this.csD.csx;
                    pVar2.b(aVar10, arrayList);
                }
            }
            aoS = this.csD.aoS();
            if (aoS) {
                aVar7 = this.csD.csy;
                if (aVar7 != null) {
                    p pVar3 = this.csD;
                    aVar8 = this.csD.csy;
                    pVar3.b(aVar8, arrayList);
                }
            }
            aoT = this.csD.aoT();
            if (aoT) {
                aVar5 = this.csD.csz;
                if (aVar5 != null) {
                    p pVar4 = this.csD;
                    aVar6 = this.csD.csz;
                    pVar4.b(aVar6, arrayList);
                }
            }
            aoU = this.csD.aoU();
            if (aoU) {
                aVar2 = this.csD.csA;
                if (aVar2 != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar3 = this.csD.csA;
                    aVar3.iJ(z ? 1 : 0);
                    p pVar5 = this.csD;
                    aVar4 = this.csD.csA;
                    pVar5.b(aVar4, arrayList);
                }
            }
            this.csD.b(new a(y.account_manager, u.icon_home_change, 5), arrayList);
            this.csD.b(new a(y.app_tieba_exit, u.icon_home_quit, 7), arrayList);
            com.baidu.tbadk.core.message.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (com.baidu.tieba.tbadkCore.f.a aVar11 : data.list) {
                    this.csD.b(aVar11, arrayList);
                }
            }
            if (data.Sg != null) {
                data.Sg.j(arrayList);
            }
        }
    }
}
