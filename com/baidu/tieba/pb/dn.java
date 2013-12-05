package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements com.baidu.tieba.view.ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(cr crVar) {
        this.f2236a = crVar;
    }

    @Override // com.baidu.tieba.view.ap
    public void a(int i) {
        ed edVar;
        PbEditor pbEditor;
        if (!this.f2236a.x()) {
            pbEditor = this.f2236a.an;
            pbEditor.a(i);
        } else {
            edVar = this.f2236a.q;
            edVar.a(i);
        }
        switch (i) {
            case 0:
                this.f2236a.ae = true;
                return;
            case 1:
                this.f2236a.ae = false;
                return;
            default:
                return;
        }
    }
}
