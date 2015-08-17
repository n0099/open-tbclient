package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* loaded from: classes.dex */
class z implements g.a {
    final /* synthetic */ MsgRemindActivity cxX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MsgRemindActivity msgRemindActivity) {
        this.cxX = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.model.g.a
    public void a(int i, boolean z, boolean z2) {
        if (i == 14) {
            BdSwitchView alU = MsgRemindActivity.a(this.cxX).alU();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xq().cV(300);
                    MsgRemindActivity.a(this.cxX).ff(true);
                    SettingStatic.p(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xq().cV(0);
                    MsgRemindActivity.a(this.cxX).ff(false);
                    SettingStatic.p(0, false);
                }
                if (alU != null) {
                    com.baidu.adp.lib.g.h.hi().postDelayed(new aa(this, z2, alU), 500L);
                }
            } else if (alU != null) {
                com.baidu.adp.lib.g.h.hi().postDelayed(new ab(this, z2, alU), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aL(z2);
            }
            MsgRemindActivity.a(this.cxX).amn();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aM(z2);
            }
            MsgRemindActivity.a(this.cxX).amo();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aB(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cxX.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            MsgRemindActivity.a(this.cxX).amq();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aA(z2);
                SettingStatic.p(1, z2);
            }
            MsgRemindActivity.a(this.cxX).amp();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aK(z2);
            }
            MsgRemindActivity.a(this.cxX).aml();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xq().aC(z2);
            }
            MsgRemindActivity.a(this.cxX).amm();
        } else if (i == 6) {
            if (z) {
                TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
                return;
            }
            BdSwitchView alS = MsgRemindActivity.a(this.cxX).alS();
            if (alS != null) {
                com.baidu.adp.lib.g.h.hi().postDelayed(new ac(this, z2, alS), 500L);
            }
        }
    }
}
