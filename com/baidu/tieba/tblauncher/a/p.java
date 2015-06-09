package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ o cwO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(i);
        this.cwO = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean aqG;
        boolean aqH;
        boolean aqI;
        boolean aqJ;
        boolean aqK;
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
        if (customResponsedMessage != null && (customResponsedMessage instanceof LeftNaviScanMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.message.a)) {
            ArrayList arrayList = new ArrayList();
            aqG = this.cwO.aqG();
            if (aqG) {
                aVar10 = this.cwO.cwM;
                if (aVar10 != null) {
                    o oVar = this.cwO;
                    aVar11 = this.cwO.cwM;
                    oVar.b(aVar11, arrayList);
                }
            }
            aqH = this.cwO.aqH();
            if (aqH) {
                aVar8 = this.cwO.cwI;
                if (aVar8 != null) {
                    o oVar2 = this.cwO;
                    aVar9 = this.cwO.cwI;
                    oVar2.b(aVar9, arrayList);
                }
            }
            aqI = this.cwO.aqI();
            if (aqI) {
                aVar6 = this.cwO.cwJ;
                if (aVar6 != null) {
                    o oVar3 = this.cwO;
                    aVar7 = this.cwO.cwJ;
                    oVar3.b(aVar7, arrayList);
                }
            }
            aqJ = this.cwO.aqJ();
            if (aqJ) {
                aVar4 = this.cwO.cwK;
                if (aVar4 != null) {
                    o oVar4 = this.cwO;
                    aVar5 = this.cwO.cwK;
                    oVar4.b(aVar5, arrayList);
                }
            }
            aqK = this.cwO.aqK();
            if (aqK) {
                aVar = this.cwO.cwL;
                if (aVar != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar2 = this.cwO.cwL;
                    aVar2.jf(z ? 1 : 0);
                    o oVar5 = this.cwO;
                    aVar3 = this.cwO.cwL;
                    oVar5.b(aVar3, arrayList);
                }
            }
            this.cwO.b(new a(t.account_manager, com.baidu.tieba.p.icon_home_change, 5), arrayList);
            this.cwO.b(new a(t.app_tieba_exit, com.baidu.tieba.p.icon_home_quit, 7), arrayList);
            com.baidu.tbadk.core.message.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (com.baidu.tieba.tbadkCore.f.a aVar12 : data.list) {
                    this.cwO.b(aVar12, arrayList);
                }
            }
            if (data.SP != null) {
                data.SP.k(arrayList);
            }
        }
    }
}
