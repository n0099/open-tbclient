package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements g.a {
    final /* synthetic */ MsgRemindActivity duZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MsgRemindActivity msgRemindActivity) {
        this.duZ = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.model.g.a
    public void a(int i, boolean z, boolean z2) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        ah ahVar4;
        ah ahVar5;
        ah ahVar6;
        ah ahVar7;
        ah ahVar8;
        ah ahVar9;
        ah ahVar10;
        if (i == 14) {
            ahVar8 = this.duZ.duX;
            BdSwitchView aAL = ahVar8.aAL();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xS().dl(300);
                    ahVar10 = this.duZ.duX;
                    ahVar10.hc(true);
                    SettingStatic.t(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xS().dl(0);
                    ahVar9 = this.duZ.duX;
                    ahVar9.hc(false);
                    SettingStatic.t(0, false);
                }
                if (aAL != null) {
                    com.baidu.adp.lib.h.h.hj().postDelayed(new ad(this, z2, aAL), 500L);
                }
            } else if (aAL != null) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new ae(this, z2, aAL), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aM(z2);
            }
            ahVar7 = this.duZ.duX;
            ahVar7.aBe();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aN(z2);
            }
            ahVar6 = this.duZ.duX;
            ahVar6.aBf();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aC(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.duZ.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            ahVar5 = this.duZ.duX;
            ahVar5.aBh();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aB(z2);
                SettingStatic.t(1, z2);
            }
            ahVar4 = this.duZ.duX;
            ahVar4.aBg();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aL(z2);
            }
            ahVar3 = this.duZ.duX;
            ahVar3.aBc();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xS().aD(z2);
            }
            ahVar2 = this.duZ.duX;
            ahVar2.aBd();
        } else if (i == 6) {
            if (!z) {
                ahVar = this.duZ.duX;
                BdSwitchView aAJ = ahVar.aAJ();
                if (aAJ != null) {
                    com.baidu.adp.lib.h.h.hj().postDelayed(new af(this, z2, aAJ), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
