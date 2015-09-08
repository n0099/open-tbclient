package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ o cWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(i);
        this.cWa = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean awA;
        boolean awB;
        boolean awC;
        boolean awD;
        boolean awE;
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        a aVar5;
        a aVar6;
        a aVar7;
        a aVar8;
        a aVar9;
        a aVar10;
        a aVar11;
        a aVar12;
        if (customResponsedMessage != null && (customResponsedMessage instanceof LeftNaviScanMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof LeftNaviScanMessage.a)) {
            ArrayList arrayList = new ArrayList();
            awA = this.cWa.awA();
            if (awA) {
                aVar11 = this.cWa.cVY;
                if (aVar11 != null) {
                    o oVar = this.cWa;
                    aVar12 = this.cWa.cVY;
                    oVar.b(aVar12, arrayList);
                }
            }
            awB = this.cWa.awB();
            if (awB) {
                aVar9 = this.cWa.cVU;
                if (aVar9 != null) {
                    o oVar2 = this.cWa;
                    aVar10 = this.cWa.cVU;
                    oVar2.b(aVar10, arrayList);
                }
            }
            awC = this.cWa.awC();
            if (awC) {
                aVar7 = this.cWa.cVV;
                if (aVar7 != null) {
                    o oVar3 = this.cWa;
                    aVar8 = this.cWa.cVV;
                    oVar3.b(aVar8, arrayList);
                }
            }
            awD = this.cWa.awD();
            if (awD) {
                aVar4 = this.cWa.cVW;
                if (aVar4 != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar5 = this.cWa.cVW;
                    aVar5.kK(z ? 1 : 0);
                    o oVar4 = this.cWa;
                    aVar6 = this.cWa.cVW;
                    oVar4.b(aVar6, arrayList);
                }
            }
            awE = this.cWa.awE();
            if (awE) {
                aVar = this.cWa.cVX;
                if (aVar != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar2 = this.cWa.cVX;
                    aVar2.kK(z2 ? 1 : 0);
                    o oVar5 = this.cWa;
                    aVar3 = this.cWa.cVX;
                    oVar5.b(aVar3, arrayList);
                }
            }
            this.cWa.b(new a(i.h.account_manager, i.e.icon_home_change, 5), arrayList);
            this.cWa.b(new a(i.h.app_tieba_exit, i.e.icon_home_quit, 7), arrayList);
            LeftNaviScanMessage.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (com.baidu.tieba.tbadkCore.f.a aVar13 : data.list) {
                    this.cWa.b(aVar13, arrayList);
                }
            }
            if (data.XS != null) {
                data.XS.l(arrayList);
            }
        }
    }
}
