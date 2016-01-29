package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements g.a {
    final /* synthetic */ MsgRemindActivity dLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MsgRemindActivity msgRemindActivity) {
        this.dLd = msgRemindActivity;
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
            ahVar8 = this.dLd.dLb;
            BdSwitchView aHS = ahVar8.aHS();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.zk().dH(300);
                    ahVar10 = this.dLd.dLb;
                    ahVar10.hC(true);
                    SettingStatic.v(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.zk().dH(0);
                    ahVar9 = this.dLd.dLb;
                    ahVar9.hC(false);
                    SettingStatic.v(0, false);
                }
                if (aHS != null) {
                    com.baidu.adp.lib.h.h.hr().postDelayed(new ad(this, z2, aHS), 500L);
                }
            } else if (aHS != null) {
                com.baidu.adp.lib.h.h.hr().postDelayed(new ae(this, z2, aHS), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aN(z2);
            }
            ahVar7 = this.dLd.dLb;
            ahVar7.aIl();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aO(z2);
            }
            ahVar6 = this.dLd.dLb;
            ahVar6.aIm();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aD(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.dLd.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            ahVar5 = this.dLd.dLb;
            ahVar5.aIo();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aC(z2);
                SettingStatic.v(1, z2);
            }
            ahVar4 = this.dLd.dLb;
            ahVar4.aIn();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aM(z2);
            }
            ahVar3 = this.dLd.dLb;
            ahVar3.aIj();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.zk().aE(z2);
            }
            ahVar2 = this.dLd.dLb;
            ahVar2.aIk();
        } else if (i == 6) {
            if (!z) {
                ahVar = this.dLd.dLb;
                BdSwitchView aHQ = ahVar.aHQ();
                if (aHQ != null) {
                    com.baidu.adp.lib.h.h.hr().postDelayed(new af(this, z2, aHQ), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
