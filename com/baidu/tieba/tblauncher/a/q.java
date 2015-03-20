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
    final /* synthetic */ p csn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.csn = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        a aVar;
        boolean aoC;
        boolean aoD;
        boolean aoE;
        boolean aoF;
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
            p pVar = this.csn;
            aVar = this.csn.csl;
            pVar.b(aVar, arrayList);
            aoC = this.csn.aoC();
            if (aoC) {
                aVar9 = this.csn.csh;
                if (aVar9 != null) {
                    p pVar2 = this.csn;
                    aVar10 = this.csn.csh;
                    pVar2.b(aVar10, arrayList);
                }
            }
            aoD = this.csn.aoD();
            if (aoD) {
                aVar7 = this.csn.csi;
                if (aVar7 != null) {
                    p pVar3 = this.csn;
                    aVar8 = this.csn.csi;
                    pVar3.b(aVar8, arrayList);
                }
            }
            aoE = this.csn.aoE();
            if (aoE) {
                aVar5 = this.csn.csj;
                if (aVar5 != null) {
                    p pVar4 = this.csn;
                    aVar6 = this.csn.csj;
                    pVar4.b(aVar6, arrayList);
                }
            }
            aoF = this.csn.aoF();
            if (aoF) {
                aVar2 = this.csn.csk;
                if (aVar2 != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar3 = this.csn.csk;
                    aVar3.iG(z ? 1 : 0);
                    p pVar5 = this.csn;
                    aVar4 = this.csn.csk;
                    pVar5.b(aVar4, arrayList);
                }
            }
            this.csn.b(new a(y.account_manager, u.icon_home_change, 5), arrayList);
            this.csn.b(new a(y.app_tieba_exit, u.icon_home_quit, 7), arrayList);
            com.baidu.tbadk.core.message.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (com.baidu.tieba.tbadkCore.f.a aVar11 : data.list) {
                    this.csn.b(aVar11, arrayList);
                }
            }
            if (data.Se != null) {
                data.Se.j(arrayList);
            }
        }
    }
}
