package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0033a {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0033a
    public void a(boolean z, boolean z2, String str) {
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        ao aoVar;
        ao aoVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        ao aoVar3;
        ao aoVar4;
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
        SubPbModel subPbModel5;
        com.baidu.tbadk.baseEditMark.a aVar4;
        if (z) {
            aVar = this.eye.dHz;
            if (aVar != null) {
                aVar4 = this.eye.dHz;
                aVar4.ac(z2);
            }
            aVar2 = this.eye.dHz;
            MarkData nG = aVar2.nG();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(nG);
                aVar3 = this.eye.dHz;
                if (aVar3 != null) {
                    if (nG != null) {
                        subPbModel3 = this.eye.exN;
                        subPbModel3.iI(true);
                        subPbModel4 = this.eye.exN;
                        subPbModel5 = this.eye.exN;
                        subPbModel4.om(subPbModel5.CH());
                        this.eye.showToast(w.l.add_mark_on_pb);
                    } else {
                        this.eye.showToast(this.eye.getPageContext().getString(w.l.add_mark));
                    }
                    aoVar3 = this.eye.exP;
                    if (aoVar3 != null) {
                        aoVar4 = this.eye.exP;
                        aoVar4.jf(true);
                    }
                }
            } else {
                dVar.setData(null);
                subPbModel = this.eye.exN;
                subPbModel.iI(false);
                subPbModel2 = this.eye.exN;
                subPbModel2.om(null);
                this.eye.showToast(this.eye.getPageContext().getString(w.l.remove_mark));
                aoVar = this.eye.exP;
                if (aoVar != null) {
                    aoVar2 = this.eye.exP;
                    aoVar2.jf(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.eye.showToast(this.eye.getPageContext().getString(w.l.update_mark_failed));
    }
}
