package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.InterfaceC0039a {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0039a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        am amVar;
        am amVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        am amVar3;
        am amVar4;
        am amVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.cnS.cjk;
            if (aVar != null) {
                aVar4 = this.cnS.cjk;
                aVar4.ab(z2);
            }
            aVar2 = this.cnS.cjk;
            MarkData ql = aVar2.ql();
            ao aoVar = new ao();
            aoVar.setType(2);
            if (z2) {
                aoVar.setData(ql);
                aVar3 = this.cnS.cjk;
                if (aVar3 != null) {
                    if (ql != null) {
                        amVar3 = this.cnS.cnH;
                        amVar3.eV(true);
                        amVar4 = this.cnS.cnH;
                        amVar5 = this.cnS.cnH;
                        amVar4.ka(amVar5.AV());
                        this.cnS.showToast(MessageFormat.format(this.cnS.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(ql.getFloor())));
                    } else {
                        this.cnS.showToast(this.cnS.getPageContext().getString(i.h.add_mark));
                    }
                }
            } else {
                aoVar.setData(null);
                amVar = this.cnS.cnH;
                amVar.eV(false);
                amVar2 = this.cnS.cnH;
                amVar2.ka(null);
                this.cnS.showToast(this.cnS.getPageContext().getString(i.h.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, aoVar));
            return;
        }
        this.cnS.showToast(this.cnS.getPageContext().getString(i.h.update_mark_failed));
    }
}
