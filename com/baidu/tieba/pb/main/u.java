package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bz bzVar;
        bz bzVar2;
        bzVar = this.bzj.byO;
        if (bzVar.Fh() != null) {
            bzVar2 = this.bzj.byO;
            bzVar2.Fh().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
