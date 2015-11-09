package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements g.a {
    final /* synthetic */ MsgRemindActivity cPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MsgRemindActivity msgRemindActivity) {
        this.cPq = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.model.g.a
    public void a(int i, boolean z, boolean z2) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ae aeVar4;
        ae aeVar5;
        ae aeVar6;
        ae aeVar7;
        ae aeVar8;
        ae aeVar9;
        ae aeVar10;
        if (i == 14) {
            aeVar8 = this.cPq.cPo;
            BdSwitchView atd = aeVar8.atd();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xj().dc(300);
                    aeVar10 = this.cPq.cPo;
                    aeVar10.ge(true);
                    SettingStatic.r(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xj().dc(0);
                    aeVar9 = this.cPq.cPo;
                    aeVar9.ge(false);
                    SettingStatic.r(0, false);
                }
                if (atd != null) {
                    com.baidu.adp.lib.g.h.hh().postDelayed(new aa(this, z2, atd), 500L);
                }
            } else if (atd != null) {
                com.baidu.adp.lib.g.h.hh().postDelayed(new ab(this, z2, atd), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aK(z2);
            }
            aeVar7 = this.cPq.cPo;
            aeVar7.atw();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aL(z2);
            }
            aeVar6 = this.cPq.cPo;
            aeVar6.atx();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aA(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cPq.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            aeVar5 = this.cPq.cPo;
            aeVar5.atz();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().az(z2);
                SettingStatic.r(1, z2);
            }
            aeVar4 = this.cPq.cPo;
            aeVar4.aty();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aJ(z2);
            }
            aeVar3 = this.cPq.cPo;
            aeVar3.atu();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xj().aB(z2);
            }
            aeVar2 = this.cPq.cPo;
            aeVar2.atv();
        } else if (i == 6) {
            if (!z) {
                aeVar = this.cPq.cPo;
                BdSwitchView atb = aeVar.atb();
                if (atb != null) {
                    com.baidu.adp.lib.g.h.hh().postDelayed(new ac(this, z2, atb), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
