package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements am {
    final /* synthetic */ MsgRemindActivity cfS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgRemindActivity msgRemindActivity) {
        this.cfS = msgRemindActivity;
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
            arVar9 = this.cfS.cfP;
            BdSwitchView ajs = arVar9.ajs();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.wg().cL(300);
                    arVar11 = this.cfS.cfP;
                    arVar11.eO(true);
                    MsgRemindStatic.r(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.wg().cL(0);
                    arVar10 = this.cfS.cfP;
                    arVar10.eO(false);
                    MsgRemindStatic.r(0, false);
                }
                if (ajs != null) {
                    com.baidu.adp.lib.g.i.hs().postDelayed(new af(this, z2, ajs), 500L);
                }
            } else if (ajs != null) {
                com.baidu.adp.lib.g.i.hs().postDelayed(new ag(this, z2, ajs), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aH(z2);
            }
            arVar8 = this.cfS.cfP;
            arVar8.ajM();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aI(z2);
            }
            arVar7 = this.cfS.cfP;
            arVar7.ajN();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().ax(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cfS.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            arVar6 = this.cfS.cfP;
            arVar6.ajP();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aw(z2);
                MsgRemindStatic.r(1, z2);
            }
            arVar5 = this.cfS.cfP;
            arVar5.ajO();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().aG(z2);
            }
            arVar4 = this.cfS.cfP;
            arVar4.ajK();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().ay(z2);
            }
            arVar3 = this.cfS.cfP;
            arVar3.ajL();
        } else if (i == 23) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.wg().az(z2);
                MsgRemindStatic.r(2, z2);
            }
            arVar2 = this.cfS.cfP;
            arVar2.ajQ();
        } else if (i == 6) {
            if (!z) {
                arVar = this.cfS.cfP;
                BdSwitchView ajq = arVar.ajq();
                if (ajq != null) {
                    com.baidu.adp.lib.g.i.hs().postDelayed(new ah(this, z2, ajq), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
