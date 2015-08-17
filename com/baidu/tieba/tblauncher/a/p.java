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
    final /* synthetic */ o cNt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(i);
        this.cNt = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean ash;
        boolean asi;
        boolean asj;
        boolean ask;
        boolean asl;
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
        if (customResponsedMessage != null && (customResponsedMessage instanceof LeftNaviScanMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof LeftNaviScanMessage.a)) {
            ArrayList arrayList = new ArrayList();
            ash = this.cNt.ash();
            if (ash) {
                aVar10 = this.cNt.cNr;
                if (aVar10 != null) {
                    o oVar = this.cNt;
                    aVar11 = this.cNt.cNr;
                    oVar.b(aVar11, arrayList);
                }
            }
            asi = this.cNt.asi();
            if (asi) {
                aVar8 = this.cNt.cNn;
                if (aVar8 != null) {
                    o oVar2 = this.cNt;
                    aVar9 = this.cNt.cNn;
                    oVar2.b(aVar9, arrayList);
                }
            }
            asj = this.cNt.asj();
            if (asj) {
                aVar6 = this.cNt.cNo;
                if (aVar6 != null) {
                    o oVar3 = this.cNt;
                    aVar7 = this.cNt.cNo;
                    oVar3.b(aVar7, arrayList);
                }
            }
            ask = this.cNt.ask();
            if (ask) {
                aVar4 = this.cNt.cNp;
                if (aVar4 != null) {
                    o oVar4 = this.cNt;
                    aVar5 = this.cNt.cNp;
                    oVar4.b(aVar5, arrayList);
                }
            }
            asl = this.cNt.asl();
            if (asl) {
                aVar = this.cNt.cNq;
                if (aVar != null) {
                    boolean z = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("show_member_new_icon_" + TbadkCoreApplication.m411getInst().getVersionCode() + TbadkCoreApplication.getCurrentAccount(), true);
                    aVar2 = this.cNt.cNq;
                    aVar2.jZ(z ? 1 : 0);
                    o oVar5 = this.cNt;
                    aVar3 = this.cNt.cNq;
                    oVar5.b(aVar3, arrayList);
                }
            }
            this.cNt.b(new a(i.C0057i.account_manager, i.e.icon_home_change, 5), arrayList);
            this.cNt.b(new a(i.C0057i.app_tieba_exit, i.e.icon_home_quit, 7), arrayList);
            LeftNaviScanMessage.a data = ((LeftNaviScanMessage) customResponsedMessage).getData();
            if (data.list != null && data.list.size() > 0) {
                for (com.baidu.tieba.tbadkCore.f.a aVar12 : data.list) {
                    this.cNt.b(aVar12, arrayList);
                }
            }
            if (data.XJ != null) {
                data.XJ.k(arrayList);
            }
        }
    }
}
