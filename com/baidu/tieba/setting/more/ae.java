package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ae implements am {
    final /* synthetic */ MsgRemindActivity cbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.cbq = msgRemindActivity;
    }

    @Override // com.baidu.tieba.setting.more.am
    public void a(int i, boolean z, boolean z2) {
        ar arVar;
        ar arVar2;
        ar arVar3;
        ar arVar4;
        ar arVar5;
        ar arVar6;
        ar arVar7;
        ar arVar8;
        ar arVar9;
        ar arVar10;
        ar arVar11;
        if (i == 14) {
            arVar9 = this.cbq.cbn;
            BdSwitchView ahB = arVar9.ahB();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.vw().cE(300);
                    arVar11 = this.cbq.cbn;
                    arVar11.eu(true);
                    MsgRemindStatic.s(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.vw().cE(0);
                    arVar10 = this.cbq.cbn;
                    arVar10.eu(false);
                    MsgRemindStatic.s(0, false);
                }
                if (ahB != null) {
                    com.baidu.adp.lib.g.i.hI().postDelayed(new af(this, z2, ahB), 500L);
                }
            } else if (ahB != null) {
                com.baidu.adp.lib.g.i.hI().postDelayed(new ag(this, z2, ahB), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().aA(z2);
            }
            arVar8 = this.cbq.cbn;
            arVar8.ahV();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().aB(z2);
            }
            arVar7 = this.cbq.cbn;
            arVar7.ahW();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().aq(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cbq.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            arVar6 = this.cbq.cbn;
            arVar6.ahY();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().ap(z2);
                MsgRemindStatic.s(1, z2);
            }
            arVar5 = this.cbq.cbn;
            arVar5.ahX();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().az(z2);
            }
            arVar4 = this.cbq.cbn;
            arVar4.ahT();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().ar(z2);
            }
            arVar3 = this.cbq.cbn;
            arVar3.ahU();
        } else if (i == 23) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.vw().as(z2);
                MsgRemindStatic.s(2, z2);
            }
            arVar2 = this.cbq.cbn;
            arVar2.ahZ();
        } else if (i == 6) {
            if (!z) {
                arVar = this.cbq.cbn;
                BdSwitchView ahz = arVar.ahz();
                if (ahz != null) {
                    com.baidu.adp.lib.g.i.hI().postDelayed(new ah(this, z2, ahz), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
