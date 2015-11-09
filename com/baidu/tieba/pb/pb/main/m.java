package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class m implements a.InterfaceC0039a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0039a
    public void a(boolean z, boolean z2, String str) {
        ct ctVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        ca caVar;
        ca caVar2;
        ct ctVar2;
        ca caVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        ctVar = this.cjN.cjo;
        ctVar.ahd();
        if (z) {
            aVar = this.cjN.cjk;
            if (aVar != null) {
                aVar4 = this.cjN.cjk;
                aVar4.ab(z2);
            }
            caVar = this.cjN.cjj;
            caVar.eC(z2);
            caVar2 = this.cjN.cjj;
            if (!caVar2.qi()) {
                ctVar2 = this.cjN.cjo;
                caVar3 = this.cjN.cjj;
                ctVar2.h(caVar3.getPbData());
            } else {
                this.cjN.afS();
            }
            if (z2) {
                aVar2 = this.cjN.cjk;
                if (aVar2 != null) {
                    aVar3 = this.cjN.cjk;
                    MarkData ql = aVar3.ql();
                    if (ql != null) {
                        this.cjN.showToast(MessageFormat.format(this.cjN.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(ql.getFloor())));
                        return;
                    } else {
                        this.cjN.showToast(this.cjN.getPageContext().getString(i.h.add_mark));
                        return;
                    }
                }
                return;
            }
            this.cjN.showToast(this.cjN.getPageContext().getString(i.h.remove_mark));
            return;
        }
        this.cjN.showToast(this.cjN.getPageContext().getString(i.h.update_mark_failed));
    }
}
