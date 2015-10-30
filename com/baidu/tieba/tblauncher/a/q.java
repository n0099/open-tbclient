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
    final /* synthetic */ p dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.dej = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean ayY;
        boolean ayZ;
        boolean aza;
        boolean azb;
        boolean azc;
        boolean azd;
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
            ayY = this.dej.ayY();
            if (ayY) {
                bVar13 = this.dej.deg;
                if (bVar13 != null) {
                    p pVar = this.dej;
                    bVar14 = this.dej.deg;
                    pVar.b(bVar14, arrayList);
                }
            }
            ayZ = this.dej.ayZ();
            if (ayZ) {
                bVar11 = this.dej.dec;
                if (bVar11 != null) {
                    p pVar2 = this.dej;
                    bVar12 = this.dej.dec;
                    pVar2.b(bVar12, arrayList);
                }
            }
            aza = this.dej.aza();
            if (aza) {
                bVar9 = this.dej.ded;
                if (bVar9 != null) {
                    p pVar3 = this.dej;
                    bVar10 = this.dej.ded;
                    pVar3.b(bVar10, arrayList);
                }
            }
            azb = this.dej.azb();
            if (azb) {
                bVar6 = this.dej.dee;
                if (bVar6 != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), true);
                    bVar7 = this.dej.dee;
                    bVar7.lp(z ? 1 : 0);
                    p pVar4 = this.dej;
                    bVar8 = this.dej.dee;
                    pVar4.b(bVar8, arrayList);
                }
            }
            azc = this.dej.azc();
            if (azc) {
                bVar3 = this.dej.def;
                if (bVar3 != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    bVar4 = this.dej.def;
                    bVar4.lp(z2 ? 1 : 0);
                    p pVar5 = this.dej;
                    bVar5 = this.dej.def;
                    pVar5.b(bVar5, arrayList);
                }
            }
            azd = this.dej.azd();
            if (azd) {
                bVar = this.dej.deh;
                if (bVar != null) {
                    p pVar6 = this.dej;
                    bVar2 = this.dej.deh;
                    pVar6.b(bVar2, arrayList);
                }
            }
            this.dej.b(new b(i.h.account_manager, i.e.icon_home_change, 6), arrayList);
            this.dej.b(new b(i.h.app_tieba_exit, i.e.icon_home_quit, 8), arrayList);
            LeftNaviScanMessage.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (a aVar : data.list) {
                    this.dej.b(aVar, arrayList);
                }
            }
            if (data.dcr != null) {
                data.dcr.bw(arrayList);
            }
        }
    }
}
