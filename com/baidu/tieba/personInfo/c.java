package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bJY = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void jx() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bJY.bJN;
        vVar.acc();
        aeVar = this.bJY.bJO;
        if (aeVar.acf() != null) {
            aeVar2 = this.bJY.bJO;
            aeVar2.acf().jv();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void jw() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bJY.bJO;
        if (aeVar.acf() != null) {
            aeVar2 = this.bJY.bJO;
            aeVar2.acf().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bJY.bJO;
        if (aeVar.acf() != null) {
            aeVar2 = this.bJY.bJO;
            aeVar2.acf().j(f);
        }
    }
}
