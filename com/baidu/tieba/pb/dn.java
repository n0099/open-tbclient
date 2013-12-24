package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements com.baidu.tieba.view.ap {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.tieba.view.ap
    public void a(int i) {
        ed edVar;
        PbEditor pbEditor;
        if (!this.a.x()) {
            pbEditor = this.a.an;
            pbEditor.a(i);
        } else {
            edVar = this.a.q;
            edVar.a(i);
        }
        switch (i) {
            case 0:
                this.a.ae = true;
                return;
            case 1:
                this.a.ae = false;
                return;
            default:
                return;
        }
    }
}
