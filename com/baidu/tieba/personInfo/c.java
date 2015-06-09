package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bVf = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nf() {
        v vVar;
        ad adVar;
        ad adVar2;
        vVar = this.bVf.bUU;
        vVar.afF();
        adVar = this.bVf.bUV;
        if (adVar.afJ() != null) {
            adVar2 = this.bVf.bUV;
            adVar2.afJ().nd();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ne() {
        ad adVar;
        ad adVar2;
        adVar = this.bVf.bUV;
        if (adVar.afJ() != null) {
            adVar2 = this.bVf.bUV;
            adVar2.afJ().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ad adVar;
        ad adVar2;
        adVar = this.bVf.bUV;
        if (adVar.afJ() != null) {
            adVar2 = this.bVf.bUV;
            adVar2.afJ().j(f);
        }
    }
}
