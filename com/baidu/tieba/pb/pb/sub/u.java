package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.InterfaceC0040a {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0040a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        an anVar;
        an anVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        an anVar3;
        an anVar4;
        an anVar5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.cHd.cBH;
            if (aVar != null) {
                aVar4 = this.cHd.cBH;
                aVar4.ab(z2);
            }
            aVar2 = this.cHd.cBH;
            MarkData qs = aVar2.qs();
            ap apVar = new ap();
            apVar.setType(2);
            if (z2) {
                apVar.setData(qs);
                aVar3 = this.cHd.cBH;
                if (aVar3 != null) {
                    if (qs != null) {
                        anVar3 = this.cHd.cGS;
                        anVar3.fz(true);
                        anVar4 = this.cHd.cGS;
                        anVar5 = this.cHd.cGS;
                        anVar4.kR(anVar5.BU());
                        this.cHd.showToast(MessageFormat.format(this.cHd.getPageContext().getString(n.i.add_mark_on_pb), Integer.valueOf(qs.getFloor())));
                    } else {
                        this.cHd.showToast(this.cHd.getPageContext().getString(n.i.add_mark));
                    }
                }
            } else {
                apVar.setData(null);
                anVar = this.cHd.cGS;
                anVar.fz(false);
                anVar2 = this.cHd.cGS;
                anVar2.kR(null);
                this.cHd.showToast(this.cHd.getPageContext().getString(n.i.remove_mark));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, apVar));
            return;
        }
        this.cHd.showToast(this.cHd.getPageContext().getString(n.i.update_mark_failed));
    }
}
