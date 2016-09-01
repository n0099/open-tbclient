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
public class c implements a.InterfaceC0032a {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        ax axVar;
        ax axVar2;
        ag agVar;
        ag agVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ag agVar3;
        ag agVar4;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.evy.dKY;
            if (aVar != null) {
                aVar4 = this.evy.dKY;
                aVar4.ad(z2);
            }
            aVar2 = this.evy.dKY;
            MarkData ny = aVar2.ny();
            com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
            eVar.setType(2);
            if (z2) {
                eVar.setData(ny);
                aVar3 = this.evy.dKY;
                if (aVar3 != null) {
                    if (ny != null) {
                        axVar3 = this.evy.evl;
                        axVar3.in(true);
                        axVar4 = this.evy.evl;
                        axVar5 = this.evy.evl;
                        axVar4.pl(axVar5.Dg());
                        this.evy.showToast(MessageFormat.format(this.evy.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(ny.getFloor())));
                    } else {
                        this.evy.showToast(this.evy.getPageContext().getString(t.j.add_mark));
                    }
                    agVar3 = this.evy.evn;
                    if (agVar3 != null) {
                        agVar4 = this.evy.evn;
                        agVar4.iF(true);
                    }
                }
            } else {
                eVar.setData(null);
                axVar = this.evy.evl;
                axVar.in(false);
                axVar2 = this.evy.evl;
                axVar2.pl(null);
                this.evy.showToast(this.evy.getPageContext().getString(t.j.remove_mark));
                agVar = this.evy.evn;
                if (agVar != null) {
                    agVar2 = this.evy.evn;
                    agVar2.iF(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            return;
        }
        this.evy.showToast(this.evy.getPageContext().getString(t.j.update_mark_failed));
    }
}
