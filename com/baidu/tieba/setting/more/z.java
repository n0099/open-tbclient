package com.baidu.tieba.setting.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements g.a {
    final /* synthetic */ MsgRemindActivity cNv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MsgRemindActivity msgRemindActivity) {
        this.cNv = msgRemindActivity;
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
            aeVar8 = this.cNv.cNt;
            BdSwitchView asv = aeVar8.asv();
            if (z) {
                if (z2) {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xh().dc(300);
                    aeVar10 = this.cNv.cNt;
                    aeVar10.gb(true);
                    SettingStatic.r(0, true);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.c.xh().dc(0);
                    aeVar9 = this.cNv.cNt;
                    aeVar9.gb(false);
                    SettingStatic.r(0, false);
                }
                if (asv != null) {
                    com.baidu.adp.lib.g.h.hg().postDelayed(new aa(this, z2, asv), 500L);
                }
            } else if (asv != null) {
                com.baidu.adp.lib.g.h.hg().postDelayed(new ab(this, z2, asv), 500L);
            }
        } else if (i == 2) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aK(z2);
            }
            aeVar7 = this.cNv.cNt;
            aeVar7.asO();
        } else if (i == 3) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aL(z2);
            }
            aeVar6 = this.cNv.cNt;
            aeVar6.asP();
        } else if (i == 4) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aA(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.cNv.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            aeVar5 = this.cNv.cNt;
            aeVar5.asR();
        } else if (i == 5) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().az(z2);
                SettingStatic.r(1, z2);
            }
            aeVar4 = this.cNv.cNt;
            aeVar4.asQ();
        } else if (i == 1) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aJ(z2);
            }
            aeVar3 = this.cNv.cNt;
            aeVar3.asM();
        } else if (i == 13) {
            if (z) {
                com.baidu.tbadk.coreExtra.messageCenter.c.xh().aB(z2);
            }
            aeVar2 = this.cNv.cNt;
            aeVar2.asN();
        } else if (i == 6) {
            if (!z) {
                aeVar = this.cNv.cNt;
                BdSwitchView ast = aeVar.ast();
                if (ast != null) {
                    com.baidu.adp.lib.g.h.hg().postDelayed(new ac(this, z2, ast), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m411getInst().setPromotedMessage(z2);
        }
    }
}
