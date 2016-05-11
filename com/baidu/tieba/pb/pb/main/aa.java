package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class aa implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        el elVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        cw cwVar;
        cw cwVar2;
        el elVar2;
        cw cwVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        elVar = this.djE.diR;
        elVar.azd();
        if (z) {
            aVar = this.djE.cPW;
            if (aVar != null) {
                aVar4 = this.djE.cPW;
                aVar4.aa(z2);
            }
            cwVar = this.djE.dih;
            cwVar.gG(z2);
            cwVar2 = this.djE.dih;
            if (!cwVar2.mP()) {
                elVar2 = this.djE.diR;
                cwVar3 = this.djE.dih;
                elVar2.j(cwVar3.getPbData());
            } else {
                this.djE.awF();
            }
            if (z2) {
                aVar2 = this.djE.cPW;
                if (aVar2 != null) {
                    aVar3 = this.djE.cPW;
                    MarkData mS = aVar3.mS();
                    if (mS != null) {
                        this.djE.showToast(MessageFormat.format(this.djE.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(mS.getFloor())));
                        return;
                    } else {
                        this.djE.showToast(this.djE.getPageContext().getString(t.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.djE.showToast(this.djE.getPageContext().getString(t.j.remove_mark));
            return;
        }
        this.djE.showToast(this.djE.getPageContext().getString(t.j.update_mark_failed));
    }
}
