package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements g.a {
    final /* synthetic */ MsgRemindActivity edA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.edA = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.model.g.a
    public void a(int i, boolean z, boolean z2) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        aj ajVar4;
        aj ajVar5;
        aj ajVar6;
        aj ajVar7;
        aj ajVar8;
        aj ajVar9;
        aj ajVar10;
        aj ajVar11;
        if (i == 14) {
            ajVar9 = this.edA.edy;
            BdSwitchView aOH = ajVar9.aOH();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.zM().dK(300);
                    ajVar11 = this.edA.edy;
                    ajVar11.ir(true);
                    SettingStatic.v(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.zM().dK(0);
                    ajVar10 = this.edA.edy;
                    ajVar10.ir(false);
                    SettingStatic.v(0, false);
                }
                if (aOH != null) {
                    com.baidu.adp.lib.h.h.hx().postDelayed(new af(this, z2, aOH), 500L);
                }
            } else if (aOH != null) {
                com.baidu.adp.lib.h.h.hx().postDelayed(new ag(this, z2, aOH), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aS(z2);
            }
            ajVar8 = this.edA.edy;
            ajVar8.aPa();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aT(z2);
            }
            ajVar7 = this.edA.edy;
            ajVar7.aPb();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aI(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.edA.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            ajVar6 = this.edA.edy;
            ajVar6.aPd();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aH(z2);
                SettingStatic.v(1, z2);
            }
            ajVar5 = this.edA.edy;
            ajVar5.aPc();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aR(z2);
            }
            ajVar4 = this.edA.edy;
            ajVar4.aOY();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aJ(z2);
            }
            ajVar3 = this.edA.edy;
            ajVar3.aOZ();
        } else if (i == 6) {
            if (!z) {
                ajVar2 = this.edA.edy;
                BdSwitchView aOE = ajVar2.aOE();
                if (aOE != null) {
                    com.baidu.adp.lib.h.h.hx().postDelayed(new ah(this, z2, aOE), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        } else if (i == 7) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zM().aV(z2);
            }
            ajVar = this.edA.edy;
            ajVar.aOu();
        }
    }
}
