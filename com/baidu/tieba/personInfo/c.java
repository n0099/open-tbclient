package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bIm = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void jw() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bIm.bIb;
        vVar.aby();
        aeVar = this.bIm.bIc;
        if (aeVar.abB() != null) {
            aeVar2 = this.bIm.bIc;
            aeVar2.abB().ju();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void jv() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bIm.bIc;
        if (aeVar.abB() != null) {
            aeVar2 = this.bIm.bIc;
            aeVar2.abB().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bIm.bIc;
        if (aeVar.abB() != null) {
            aeVar2 = this.bIm.bIc;
            aeVar2.abB().j(f);
        }
    }
}
