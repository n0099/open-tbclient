package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
import java.text.MessageFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0028a {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0028a
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
            aVar = this.esV.dFo;
            if (aVar != null) {
                aVar4 = this.esV.dFo;
                aVar4.ae(z2);
            }
            aVar2 = this.esV.dFo;
            MarkData oh = aVar2.oh();
            com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
            dVar.setType(2);
            if (z2) {
                dVar.setData(oh);
                aVar3 = this.esV.dFo;
                if (aVar3 != null) {
                    if (oh != null) {
                        subPbModel3 = this.esV.esE;
                        subPbModel3.iE(true);
                        subPbModel4 = this.esV.esE;
                        subPbModel5 = this.esV.esE;
                        subPbModel4.nR(subPbModel5.DJ());
                        this.esV.showToast(MessageFormat.format(this.esV.getPageContext().getString(w.l.add_mark_on_pb), Integer.valueOf(oh.getFloor())));
                    } else {
                        this.esV.showToast(this.esV.getPageContext().getString(w.l.add_mark));
                    }
                    aoVar3 = this.esV.esG;
                    if (aoVar3 != null) {
                        aoVar4 = this.esV.esG;
                        aoVar4.iY(true);
                    }
                }
            } else {
                dVar.setData(null);
                subPbModel = this.esV.esE;
                subPbModel.iE(false);
                subPbModel2 = this.esV.esE;
                subPbModel2.nR(null);
                this.esV.showToast(this.esV.getPageContext().getString(w.l.remove_mark));
                aoVar = this.esV.esG;
                if (aoVar != null) {
                    aoVar2 = this.esV.esG;
                    aoVar2.iY(false);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            return;
        }
        this.esV.showToast(this.esV.getPageContext().getString(w.l.update_mark_failed));
    }
}
