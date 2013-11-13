package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements com.baidu.tieba.view.ao {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(cp cpVar) {
        this.f2144a = cpVar;
    }

    @Override // com.baidu.tieba.view.ao
    public void a(int i) {
        eb ebVar;
        PbEditor pbEditor;
        if (!this.f2144a.x()) {
            pbEditor = this.f2144a.an;
            pbEditor.a(i);
        } else {
            ebVar = this.f2144a.q;
            ebVar.a(i);
        }
        switch (i) {
            case 0:
                this.f2144a.ae = true;
                return;
            case 1:
                this.f2144a.ae = false;
                return;
            default:
                return;
        }
    }
}
