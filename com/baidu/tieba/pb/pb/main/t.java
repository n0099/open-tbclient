package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        ci ciVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        ci ciVar2;
        ci ciVar3;
        if (UtilHelper.isNetOk()) {
            ciVar = this.bIv.bHY;
            if (ciVar.IY() != null) {
                ciVar2 = this.bIv.bHY;
                ciVar2.IY().setLocationInfoViewState(1);
                ciVar3 = this.bIv.bHY;
                ciVar3.IY().setLocationViewVisibility(0);
            }
            eVar = this.bIv.aHv;
            eVar.anj();
        } else {
            jVar = this.bIv.aHH;
            jVar.IQ();
        }
        aVar.dismiss();
    }
}
