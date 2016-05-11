package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.InterfaceC0032a {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ap apVar;
        ap apVar2;
        y yVar;
        y yVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        y yVar3;
        y yVar4;
        ap apVar3;
        ap apVar4;
        ap apVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.dqn.cPW;
            if (aVar != null) {
                aVar4 = this.dqn.cPW;
                aVar4.aa(z2);
            }
            aVar2 = this.dqn.cPW;
            MarkData mS = aVar2.mS();
            com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
            fVar.setType(2);
            if (z2) {
                fVar.setData(mS);
                aVar3 = this.dqn.cPW;
                if (aVar3 != null) {
                    if (mS != null) {
                        apVar3 = this.dqn.dqc;
                        apVar3.gN(true);
                        apVar4 = this.dqn.dqc;
                        apVar5 = this.dqn.dqc;
                        apVar4.mn(apVar5.BB());
                        this.dqn.showToast(MessageFormat.format(this.dqn.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(mS.getFloor())));
                    } else {
                        this.dqn.showToast(this.dqn.getPageContext().getString(t.j.add_mark));
                    }
                    yVar3 = this.dqn.dqe;
                    if (yVar3 != null) {
                        yVar4 = this.dqn.dqe;
                        yVar4.he(true);
                    }
                }
            } else {
                fVar.setData(null);
                apVar = this.dqn.dqc;
                apVar.gN(false);
                apVar2 = this.dqn.dqc;
                apVar2.mn(null);
                this.dqn.showToast(this.dqn.getPageContext().getString(t.j.remove_mark));
                yVar = this.dqn.dqe;
                if (yVar != null) {
                    yVar2 = this.dqn.dqe;
                    yVar2.he(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
            return;
        }
        this.dqn.showToast(this.dqn.getPageContext().getString(t.j.update_mark_failed));
    }
}
