package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bSh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bSh = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void mM() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bSh.bRW;
        vVar.aek();
        aeVar = this.bSh.bRX;
        if (aeVar.aen() != null) {
            aeVar2 = this.bSh.bRX;
            aeVar2.aen().mK();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void mL() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bSh.bRX;
        if (aeVar.aen() != null) {
            aeVar2 = this.bSh.bRX;
            aeVar2.aen().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bSh.bRX;
        if (aeVar.aen() != null) {
            aeVar2 = this.bSh.bRX;
            aeVar2.aen().j(f);
        }
    }
}
