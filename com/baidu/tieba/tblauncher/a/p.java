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
    final /* synthetic */ o cwN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(i);
        this.cwN = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean aqF;
        boolean aqG;
        boolean aqH;
        boolean aqI;
        boolean aqJ;
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
            aqF = this.cwN.aqF();
            if (aqF) {
                aVar10 = this.cwN.cwL;
                if (aVar10 != null) {
                    o oVar = this.cwN;
                    aVar11 = this.cwN.cwL;
                    oVar.b(aVar11, arrayList);
                }
            }
            aqG = this.cwN.aqG();
            if (aqG) {
                aVar8 = this.cwN.cwH;
                if (aVar8 != null) {
                    o oVar2 = this.cwN;
                    aVar9 = this.cwN.cwH;
                    oVar2.b(aVar9, arrayList);
                }
            }
            aqH = this.cwN.aqH();
            if (aqH) {
                aVar6 = this.cwN.cwI;
                if (aVar6 != null) {
                    o oVar3 = this.cwN;
                    aVar7 = this.cwN.cwI;
                    oVar3.b(aVar7, arrayList);
                }
            }
            aqI = this.cwN.aqI();
            if (aqI) {
                aVar4 = this.cwN.cwJ;
                if (aVar4 != null) {
                    o oVar4 = this.cwN;
                    aVar5 = this.cwN.cwJ;
                    oVar4.b(aVar5, arrayList);
                }
            }
            aqJ = this.cwN.aqJ();
            if (aqJ) {
                aVar = this.cwN.cwK;
                if (aVar != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar2 = this.cwN.cwK;
                    aVar2.jf(z ? 1 : 0);
                    o oVar5 = this.cwN;
                    aVar3 = this.cwN.cwK;
                    oVar5.b(aVar3, arrayList);
                }
            }
            this.cwN.b(new a(t.account_manager, com.baidu.tieba.p.icon_home_change, 5), arrayList);
            this.cwN.b(new a(t.app_tieba_exit, com.baidu.tieba.p.icon_home_quit, 7), arrayList);
            com.baidu.tbadk.core.message.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (com.baidu.tieba.tbadkCore.f.a aVar12 : data.list) {
                    this.cwN.b(aVar12, arrayList);
                }
            }
            if (data.SP != null) {
                data.SP.k(arrayList);
            }
        }
    }
}
