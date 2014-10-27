package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ PersonInfoActivity bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonInfoActivity personInfoActivity) {
        this.bED = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void hz() {
        v vVar;
        ae aeVar;
        ae aeVar2;
        vVar = this.bED.bEs;
        vVar.aaZ();
        aeVar = this.bED.bEt;
        if (aeVar.abc() != null) {
            aeVar2 = this.bED.bEt;
            aeVar2.abc().hx();
        }
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void hy() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bED.bEt;
        if (aeVar.abc() != null) {
            aeVar2 = this.bED.bEt;
            aeVar2.abc().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void j(float f) {
        ae aeVar;
        ae aeVar2;
        aeVar = this.bED.bEt;
        if (aeVar.abc() != null) {
            aeVar2 = this.bED.bEt;
            aeVar2.abc().i(f);
        }
    }
}
