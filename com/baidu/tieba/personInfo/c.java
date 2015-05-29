package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bVe = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void nf() {
        v vVar;
        ad adVar;
        ad adVar2;
        vVar = this.bVe.bUT;
        vVar.afE();
        adVar = this.bVe.bUU;
        if (adVar.afI() != null) {
            adVar2 = this.bVe.bUU;
            adVar2.afI().nd();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void ne() {
        ad adVar;
        ad adVar2;
        adVar = this.bVe.bUU;
        if (adVar.afI() != null) {
            adVar2 = this.bVe.bUU;
            adVar2.afI().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ad adVar;
        ad adVar2;
        adVar = this.bVe.bUU;
        if (adVar.afI() != null) {
            adVar2 = this.bVe.bUU;
            adVar2.afI().j(f);
        }
    }
}
