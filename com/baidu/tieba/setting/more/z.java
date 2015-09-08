package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements g.a {
    final /* synthetic */ MsgRemindActivity cGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MsgRemindActivity msgRemindActivity) {
        this.cGu = msgRemindActivity;
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
            aeVar8 = this.cGu.cGs;
            BdSwitchView aqd = aeVar8.aqd();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xw().db(300);
                    aeVar10 = this.cGu.cGs;
                    aeVar10.fQ(true);
                    SettingStatic.q(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xw().db(0);
                    aeVar9 = this.cGu.cGs;
                    aeVar9.fQ(false);
                    SettingStatic.q(0, false);
                }
                if (aqd != null) {
                    com.baidu.adp.lib.g.h.hf().postDelayed(new aa(this, z2, aqd), 500L);
                }
            } else if (aqd != null) {
                com.baidu.adp.lib.g.h.hf().postDelayed(new ab(this, z2, aqd), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aL(z2);
            }
            aeVar7 = this.cGu.cGs;
            aeVar7.aqw();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aM(z2);
            }
            aeVar6 = this.cGu.cGs;
            aeVar6.aqx();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aB(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cGu.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            aeVar5 = this.cGu.cGs;
            aeVar5.aqz();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aA(z2);
                SettingStatic.q(1, z2);
            }
            aeVar4 = this.cGu.cGs;
            aeVar4.aqy();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aK(z2);
            }
            aeVar3 = this.cGu.cGs;
            aeVar3.aqu();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xw().aC(z2);
            }
            aeVar2 = this.cGu.cGs;
            aeVar2.aqv();
        } else if (i == 6) {
            if (!z) {
                aeVar = this.cGu.cGs;
                BdSwitchView aqb = aeVar.aqb();
                if (aqb != null) {
                    com.baidu.adp.lib.g.h.hf().postDelayed(new ac(this, z2, aqb), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
