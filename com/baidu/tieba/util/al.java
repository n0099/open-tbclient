package com.baidu.tieba.util;
/* loaded from: classes.dex */
class al implements com.baidu.tieba.model.aj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ah f1786a;
    private final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar, am amVar) {
        this.f1786a = ahVar;
        this.b = amVar;
    }

    @Override // com.baidu.tieba.model.aj
    public void a() {
    }

    @Override // com.baidu.tieba.model.aj
    public void a(com.baidu.tieba.data.az azVar) {
        if (azVar != null && azVar.b() == 0) {
            if (this.b != null) {
                this.b.a(azVar.a());
            }
        } else if (this.b != null) {
            this.b.a(null);
        }
    }
}
