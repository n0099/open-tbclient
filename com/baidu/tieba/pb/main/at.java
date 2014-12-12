package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fa() {
        bz bzVar;
        bz bzVar2;
        bzVar = this.bzj.byO;
        if (bzVar.Fh() != null) {
            bzVar2 = this.bzj.byO;
            bzVar2.Fh().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fu(String str) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bzj.byO;
        if (bzVar.Fh() != null) {
            bzVar2 = this.bzj.byO;
            bzVar2.Fh().setLocationViewVisibility(0);
            bzVar3 = this.bzj.byO;
            bzVar3.Fh().B(2, str);
        }
    }
}
