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
public class u implements a.InterfaceC0041a {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0041a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ao aoVar;
        ao aoVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.cTK.cMG;
            if (aVar != null) {
                aVar4 = this.cTK.cMG;
                aVar4.Y(z2);
            }
            aVar2 = this.cTK.cMG;
            MarkData qj = aVar2.qj();
            com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
            eVar.setType(2);
            if (z2) {
                eVar.setData(qj);
                aVar3 = this.cTK.cMG;
                if (aVar3 != null) {
                    if (qj != null) {
                        aoVar3 = this.cTK.cTz;
                        aoVar3.fA(true);
                        aoVar4 = this.cTK.cTz;
                        aoVar5 = this.cTK.cTz;
                        aoVar4.kV(aoVar5.CZ());
                        this.cTK.showToast(MessageFormat.format(this.cTK.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(qj.getFloor())));
                    } else {
                        this.cTK.showToast(this.cTK.getPageContext().getString(t.j.add_mark));
                    }
                }
            } else {
                eVar.setData(null);
                aoVar = this.cTK.cTz;
                aoVar.fA(false);
                aoVar2 = this.cTK.cTz;
                aoVar2.kV(null);
                this.cTK.showToast(this.cTK.getPageContext().getString(t.j.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            return;
        }
        this.cTK.showToast(this.cTK.getPageContext().getString(t.j.update_mark_failed));
    }
}
