package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        cj cjVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        cj cjVar2;
        cj cjVar3;
        if (UtilHelper.isNetOk()) {
            cjVar = this.bIJ.bIl;
            if (cjVar.Je() != null) {
                cjVar2 = this.bIJ.bIl;
                cjVar2.Je().setLocationInfoViewState(1);
                cjVar3 = this.bIJ.bIl;
                cjVar3.Je().setLocationViewVisibility(0);
            }
            eVar = this.bIJ.aHD;
            eVar.any();
        } else {
            jVar = this.bIJ.aHP;
            jVar.IW();
        }
        aVar.dismiss();
    }
}
