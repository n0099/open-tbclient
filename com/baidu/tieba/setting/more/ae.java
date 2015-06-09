package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements am {
    final /* synthetic */ MsgRemindActivity cfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.cfT = msgRemindActivity;
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
            arVar9 = this.cfT.cfQ;
            BdSwitchView ajt = arVar9.ajt();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.wg().cL(300);
                    arVar11 = this.cfT.cfQ;
                    arVar11.eO(true);
                    MsgRemindStatic.r(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.wg().cL(0);
                    arVar10 = this.cfT.cfQ;
                    arVar10.eO(false);
                    MsgRemindStatic.r(0, false);
                }
                if (ajt != null) {
                    com.baidu.adp.lib.g.i.hs().postDelayed(new af(this, z2, ajt), 500L);
                }
            } else if (ajt != null) {
                com.baidu.adp.lib.g.i.hs().postDelayed(new ag(this, z2, ajt), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aH(z2);
            }
            arVar8 = this.cfT.cfQ;
            arVar8.ajN();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aI(z2);
            }
            arVar7 = this.cfT.cfQ;
            arVar7.ajO();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().ax(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cfT.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            arVar6 = this.cfT.cfQ;
            arVar6.ajQ();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aw(z2);
                MsgRemindStatic.r(1, z2);
            }
            arVar5 = this.cfT.cfQ;
            arVar5.ajP();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aG(z2);
            }
            arVar4 = this.cfT.cfQ;
            arVar4.ajL();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().ay(z2);
            }
            arVar3 = this.cfT.cfQ;
            arVar3.ajM();
        } else if (i == 23) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().az(z2);
                MsgRemindStatic.r(2, z2);
            }
            arVar2 = this.cfT.cfQ;
            arVar2.ajR();
        } else if (i == 6) {
            if (!z) {
                arVar = this.cfT.cfQ;
                BdSwitchView ajr = arVar.ajr();
                if (ajr != null) {
                    com.baidu.adp.lib.g.i.hs().postDelayed(new ah(this, z2, ajr), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
