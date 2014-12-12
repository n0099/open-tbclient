package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        bz bzVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        bz bzVar2;
        bz bzVar3;
        if (UtilHelper.isNetOk()) {
            bzVar = this.bzj.byO;
            if (bzVar.Fh() != null) {
                bzVar2 = this.bzj.byO;
                bzVar2.Fh().setLocationInfoViewState(1);
                bzVar3 = this.bzj.byO;
                bzVar3.Fh().setLocationViewVisibility(0);
            }
            dVar = this.bzj.aAD;
            dVar.ahG();
        } else {
            iVar = this.bzj.aAO;
            iVar.EZ();
        }
        aVar.dismiss();
    }
}
