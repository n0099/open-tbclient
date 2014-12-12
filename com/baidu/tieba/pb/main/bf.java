package com.baidu.tieba.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.baseEditMark.g {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.g
    public void a(boolean z, boolean z2, String str) {
        bz bzVar;
        com.baidu.tbadk.baseEditMark.e eVar;
        bq bqVar;
        bq bqVar2;
        bz bzVar2;
        bq bqVar3;
        com.baidu.tbadk.baseEditMark.e eVar2;
        bzVar = this.bzj.byO;
        bzVar.Yd();
        if (z) {
            eVar = this.bzj.byK;
            eVar.Y(z2);
            bqVar = this.bzj.byJ;
            bqVar.dM(z2);
            bqVar2 = this.bzj.byJ;
            if (!bqVar2.li()) {
                bzVar2 = this.bzj.byO;
                bqVar3 = this.bzj.byJ;
                bzVar2.e(bqVar3.getPbData());
            } else {
                this.bzj.WM();
            }
            if (z2) {
                eVar2 = this.bzj.byK;
                MarkData lj = eVar2.lj();
                if (lj != null) {
                    this.bzj.showToast(MessageFormat.format(this.bzj.getPageContext().getString(com.baidu.tieba.z.add_mark_on_pb), Integer.valueOf(lj.getFloor())));
                    return;
                } else {
                    this.bzj.showToast(this.bzj.getPageContext().getString(com.baidu.tieba.z.add_mark));
                    return;
                }
            }
            this.bzj.showToast(this.bzj.getPageContext().getString(com.baidu.tieba.z.remove_mark));
            return;
        }
        this.bzj.showToast(this.bzj.getPageContext().getString(com.baidu.tieba.z.update_mark_failed));
    }
}
