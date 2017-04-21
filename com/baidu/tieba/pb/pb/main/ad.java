package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.w;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0028a {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0028a
    public void a(boolean z, boolean z2, String str) {
        ey eyVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        ey eyVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        eyVar = this.emk.eli;
        eyVar.aOo();
        if (z) {
            aVar = this.emk.dHE;
            if (aVar != null) {
                aVar4 = this.emk.dHE;
                aVar4.ae(z2);
            }
            pbModel = this.emk.ekv;
            pbModel.iA(z2);
            pbModel2 = this.emk.ekv;
            if (!pbModel2.oe()) {
                eyVar2 = this.emk.eli;
                pbModel3 = this.emk.ekv;
                eyVar2.k(pbModel3.getPbData());
            } else {
                this.emk.aLE();
            }
            if (z2) {
                aVar2 = this.emk.dHE;
                if (aVar2 != null) {
                    aVar3 = this.emk.dHE;
                    MarkData oh = aVar3.oh();
                    if (oh != null) {
                        this.emk.showToast(MessageFormat.format(this.emk.getPageContext().getString(w.l.add_mark_on_pb), Integer.valueOf(oh.getFloor())));
                        return;
                    } else {
                        this.emk.showToast(this.emk.getPageContext().getString(w.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.emk.showToast(this.emk.getPageContext().getString(w.l.remove_mark));
            return;
        }
        this.emk.showToast(this.emk.getPageContext().getString(w.l.update_mark_failed));
    }
}
