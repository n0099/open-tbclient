package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.c {
    final /* synthetic */ PersonInfoActivity bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bJX = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void jq() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bJX.bJM;
        vVar.abX();
        aeVar = this.bJX.bJN;
        if (aeVar.aca() != null) {
            aeVar2 = this.bJX.bJN;
            aeVar2.aca().jo();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void jp() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bJX.bJN;
        if (aeVar.aca() != null) {
            aeVar2 = this.bJX.bJN;
            aeVar2.aca().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void k(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bJX.bJN;
        if (aeVar.aca() != null) {
            aeVar2 = this.bJX.bJN;
            aeVar2.aca().j(f);
        }
    }
}
