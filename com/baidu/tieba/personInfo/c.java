package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bSx = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void mM() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bSx.bSm;
        vVar.aez();
        aeVar = this.bSx.bSn;
        if (aeVar.aeC() != null) {
            aeVar2 = this.bSx.bSn;
            aeVar2.aeC().mK();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void mL() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bSx.bSn;
        if (aeVar.aeC() != null) {
            aeVar2 = this.bSx.bSn;
            aeVar2.aeC().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bSx.bSn;
        if (aeVar.aeC() != null) {
            aeVar2 = this.bSx.bSn;
            aeVar2.aeC().j(f);
        }
    }
}
