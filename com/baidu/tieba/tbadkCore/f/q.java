package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p dcW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.dcW = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean ayh;
        boolean ayi;
        boolean ayj;
        boolean ayk;
        boolean ayl;
        boolean aym;
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
            ayh = this.dcW.ayh();
            if (ayh) {
                bVar13 = this.dcW.dcT;
                if (bVar13 != null) {
                    p pVar = this.dcW;
                    bVar14 = this.dcW.dcT;
                    pVar.b(bVar14, arrayList);
                }
            }
            ayi = this.dcW.ayi();
            if (ayi) {
                bVar11 = this.dcW.dcP;
                if (bVar11 != null) {
                    p pVar2 = this.dcW;
                    bVar12 = this.dcW.dcP;
                    pVar2.b(bVar12, arrayList);
                }
            }
            ayj = this.dcW.ayj();
            if (ayj) {
                bVar9 = this.dcW.dcQ;
                if (bVar9 != null) {
                    p pVar3 = this.dcW;
                    bVar10 = this.dcW.dcQ;
                    pVar3.b(bVar10, arrayList);
                }
            }
            ayk = this.dcW.ayk();
            if (ayk) {
                bVar6 = this.dcW.dcR;
                if (bVar6 != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_my_new_icon" + TbadkCoreApplication.getCurrentAccount(), true);
                    bVar7 = this.dcW.dcR;
                    bVar7.lq(z ? 1 : 0);
                    p pVar4 = this.dcW;
                    bVar8 = this.dcW.dcR;
                    pVar4.b(bVar8, arrayList);
                }
            }
            ayl = this.dcW.ayl();
            if (ayl) {
                bVar3 = this.dcW.dcS;
                if (bVar3 != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    bVar4 = this.dcW.dcS;
                    bVar4.lq(z2 ? 1 : 0);
                    p pVar5 = this.dcW;
                    bVar5 = this.dcW.dcS;
                    pVar5.b(bVar5, arrayList);
                }
            }
            aym = this.dcW.aym();
            if (aym) {
                bVar = this.dcW.dcU;
                if (bVar != null) {
                    p pVar6 = this.dcW;
                    bVar2 = this.dcW.dcU;
                    pVar6.b(bVar2, arrayList);
                }
            }
            this.dcW.b(new b(i.h.account_manager, i.e.icon_home_change, 6), arrayList);
            this.dcW.b(new b(i.h.app_tieba_exit, i.e.icon_home_quit, 8), arrayList);
            LeftNaviScanMessage.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (a aVar : data.list) {
                    this.dcW.b(aVar, arrayList);
                }
            }
            if (data.XP != null) {
                data.XP.l(arrayList);
            }
        }
    }
}
