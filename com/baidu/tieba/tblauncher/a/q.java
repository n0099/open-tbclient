package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p ddJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.ddJ = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean ayS;
        boolean ayT;
        boolean ayU;
        boolean ayV;
        boolean ayW;
        boolean ayX;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        b bVar9;
        b bVar10;
        b bVar11;
        b bVar12;
        b bVar13;
        b bVar14;
        if (customResponsedMessage != null && (customResponsedMessage instanceof LeftNaviScanMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof LeftNaviScanMessage.a)) {
            ArrayList arrayList = new ArrayList();
            ayS = this.ddJ.ayS();
            if (ayS) {
                bVar13 = this.ddJ.ddG;
                if (bVar13 != null) {
                    p pVar = this.ddJ;
                    bVar14 = this.ddJ.ddG;
                    pVar.b(bVar14, arrayList);
                }
            }
            ayT = this.ddJ.ayT();
            if (ayT) {
                bVar11 = this.ddJ.ddC;
                if (bVar11 != null) {
                    p pVar2 = this.ddJ;
                    bVar12 = this.ddJ.ddC;
                    pVar2.b(bVar12, arrayList);
                }
            }
            ayU = this.ddJ.ayU();
            if (ayU) {
                bVar9 = this.ddJ.ddD;
                if (bVar9 != null) {
                    p pVar3 = this.ddJ;
                    bVar10 = this.ddJ.ddD;
                    pVar3.b(bVar10, arrayList);
                }
            }
            ayV = this.ddJ.ayV();
            if (ayV) {
                bVar6 = this.ddJ.ddE;
                if (bVar6 != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), true);
                    bVar7 = this.ddJ.ddE;
                    bVar7.ln(z ? 1 : 0);
                    p pVar4 = this.ddJ;
                    bVar8 = this.ddJ.ddE;
                    pVar4.b(bVar8, arrayList);
                }
            }
            ayW = this.ddJ.ayW();
            if (ayW) {
                bVar3 = this.ddJ.ddF;
                if (bVar3 != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    bVar4 = this.ddJ.ddF;
                    bVar4.ln(z2 ? 1 : 0);
                    p pVar5 = this.ddJ;
                    bVar5 = this.ddJ.ddF;
                    pVar5.b(bVar5, arrayList);
                }
            }
            ayX = this.ddJ.ayX();
            if (ayX) {
                bVar = this.ddJ.ddH;
                if (bVar != null) {
                    p pVar6 = this.ddJ;
                    bVar2 = this.ddJ.ddH;
                    pVar6.b(bVar2, arrayList);
                }
            }
            this.ddJ.b(new b(i.h.account_manager, i.e.icon_home_change, 6), arrayList);
            this.ddJ.b(new b(i.h.app_tieba_exit, i.e.icon_home_quit, 8), arrayList);
            LeftNaviScanMessage.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (a aVar : data.list) {
                    this.ddJ.b(aVar, arrayList);
                }
            }
            if (data.dbR != null) {
                data.dbR.bv(arrayList);
            }
        }
    }
}
