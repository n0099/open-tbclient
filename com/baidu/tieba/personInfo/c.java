package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bER = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void hz() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bER.bEG;
        vVar.abc();
        aeVar = this.bER.bEH;
        if (aeVar.abf() != null) {
            aeVar2 = this.bER.bEH;
            aeVar2.abf().hx();
        }
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void hy() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bER.bEH;
        if (aeVar.abf() != null) {
            aeVar2 = this.bER.bEH;
            aeVar2.abf().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void j(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bER.bEH;
        if (aeVar.abf() != null) {
            aeVar2 = this.bER.bEH;
            aeVar2.abf().i(f);
        }
    }
}
