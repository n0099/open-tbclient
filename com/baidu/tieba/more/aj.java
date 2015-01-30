package com.baidu.tieba.more;

import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements ar {
    final /* synthetic */ MsgRemindActivity bws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MsgRemindActivity msgRemindActivity) {
        this.bws = msgRemindActivity;
    }

    @Override // com.baidu.tieba.more.ar
    public void a(int i, boolean z, boolean z2) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        aw awVar6;
        aw awVar7;
        aw awVar8;
        aw awVar9;
        aw awVar10;
        aw awVar11;
        aw awVar12;
        aw awVar13;
        if (i == 14) {
            awVar9 = this.bws.bwp;
            BdSwitchView Wa = awVar9.Wa();
            if (z) {
                if (z2) {
                    TbadkCoreApplication.m255getInst().setMsgFrequency(300);
                    awVar12 = this.bws.bwp;
                    awVar12.dG(true);
                    awVar13 = this.bws.bwp;
                    awVar13.dC(true);
                    MsgRemindStatic.t(0, true);
                } else {
                    TbadkCoreApplication.m255getInst().setMsgFrequency(0);
                    awVar10 = this.bws.bwp;
                    awVar10.dG(false);
                    awVar11 = this.bws.bwp;
                    awVar11.dC(false);
                    MsgRemindStatic.t(0, false);
                }
                if (Wa != null) {
                    com.baidu.adp.lib.g.i.ej().postDelayed(new ak(this, z2, Wa), 500L);
                }
            } else if (Wa != null) {
                com.baidu.adp.lib.g.i.ej().postDelayed(new al(this, z2, Wa), 500L);
            }
        } else if (i == 2) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgAtmeOn(z2);
            }
            awVar8 = this.bws.bwp;
            awVar8.Wn();
        } else if (i == 3) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgNewFansOn(z2);
            }
            awVar7 = this.bws.bwp;
            awVar7.Wo();
        } else if (i == 4) {
            if (z) {
                TbadkCoreApplication.m255getInst().setGroupMsgOn(z2);
                if (!z2) {
                    TiebaStatic.eventStat(this.bws.getPageContext().getPageActivity(), "group_message_remind", "check_click", 1, new Object[0]);
                }
            }
            awVar6 = this.bws.bwp;
            awVar6.Wq();
        } else if (i == 5) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgChatOn(z2);
                MsgRemindStatic.t(1, z2);
            }
            awVar5 = this.bws.bwp;
            awVar5.Wp();
        } else if (i == 1) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgReplymeOn(z2);
            }
            awVar4 = this.bws.bwp;
            awVar4.Wl();
        } else if (i == 13) {
            if (z) {
                TbadkCoreApplication.m255getInst().setMsgZanOn(z2);
            }
            awVar3 = this.bws.bwp;
            awVar3.Wm();
        } else if (i == 23) {
            if (z) {
                TbadkCoreApplication.m255getInst().setStrangerChatOn(z2);
                MsgRemindStatic.t(2, z2);
            }
            awVar2 = this.bws.bwp;
            awVar2.Wr();
        } else if (i == 6) {
            if (!z) {
                awVar = this.bws.bwp;
                BdSwitchView VY = awVar.VY();
                if (VY != null) {
                    com.baidu.adp.lib.g.i.ej().postDelayed(new am(this, z2, VY), 500L);
                    return;
                }
                return;
            }
            TbadkCoreApplication.m255getInst().setPromotedMessage(z2);
        }
    }
}
