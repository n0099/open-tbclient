package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ae implements am {
    final /* synthetic */ MsgRemindActivity cbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.cbb = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.more.am
    public void a(int i, boolean z, boolean z2) {
        if (i == 14) {
            BdSwitchView ahm = this.cbb.caY.ahm();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.vq().cE(300);
                    this.cbb.caY.ew(true);
                    MsgRemindStatic.s(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.vq().cE(0);
                    this.cbb.caY.ew(false);
                    MsgRemindStatic.s(0, false);
                }
                if (ahm != null) {
                    com.baidu.adp.lib.g.i.hI().postDelayed(new af(this, z2, ahm), 500L);
                }
            } else if (ahm != null) {
                com.baidu.adp.lib.g.i.hI().postDelayed(new ag(this, z2, ahm), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().aA(z2);
            }
            this.cbb.caY.ahG();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().aB(z2);
            }
            this.cbb.caY.ahH();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().aq(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cbb.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            this.cbb.caY.ahJ();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().ap(z2);
                MsgRemindStatic.s(1, z2);
            }
            this.cbb.caY.ahI();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().az(z2);
            }
            this.cbb.caY.ahE();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().ar(z2);
            }
            this.cbb.caY.ahF();
        } else if (i == 23) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vq().as(z2);
                MsgRemindStatic.s(2, z2);
            }
            this.cbb.caY.ahK();
        } else if (i == 6) {
            if (!z) {
                BdSwitchView ahk = this.cbb.caY.ahk();
                if (ahk != null) {
                    com.baidu.adp.lib.g.i.hI().postDelayed(new ah(this, z2, ahk), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
