package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* loaded from: classes.dex */
class ab implements g.a {
    final /* synthetic */ MsgRemindActivity dnM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MsgRemindActivity msgRemindActivity) {
        this.dnM = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.model.g.a
    public void a(int i, boolean z, boolean z2) {
        if (i == 14) {
            BdSwitchView ayF = MsgRemindActivity.a(this.dnM).ayF();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.yg().ds(300);
                    MsgRemindActivity.a(this.dnM).gU(true);
                    SettingStatic.s(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.yg().ds(0);
                    MsgRemindActivity.a(this.dnM).gU(false);
                    SettingStatic.s(0, false);
                }
                if (ayF != null) {
                    com.baidu.adp.lib.h.h.hj().postDelayed(new ac(this, z2, ayF), 500L);
                }
            } else if (ayF != null) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new ad(this, z2, ayF), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aP(z2);
            }
            MsgRemindActivity.a(this.dnM).ayY();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aQ(z2);
            }
            MsgRemindActivity.a(this.dnM).ayZ();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aF(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.dnM.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            MsgRemindActivity.a(this.dnM).azb();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aE(z2);
                SettingStatic.s(1, z2);
            }
            MsgRemindActivity.a(this.dnM).aza();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aO(z2);
            }
            MsgRemindActivity.a(this.dnM).ayW();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.yg().aG(z2);
            }
            MsgRemindActivity.a(this.dnM).ayX();
        } else if (i == 6) {
            if (z) {
                TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
                return;
            }
            BdSwitchView ayD = MsgRemindActivity.a(this.dnM).ayD();
            if (ayD != null) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new ae(this, z2, ayD), 500L);
            }
        }
    }
}
