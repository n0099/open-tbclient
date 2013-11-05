package com.baidu.tieba.util;
/* loaded from: classes.dex */
class ay implements com.baidu.tieba.model.at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az f2435a;
    final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar, az azVar) {
        this.b = auVar;
        this.f2435a = azVar;
    }

    @Override // com.baidu.tieba.model.at
    public void a() {
    }

    @Override // com.baidu.tieba.model.at
    public void a(com.baidu.tieba.data.ay ayVar) {
        if (ayVar != null && ayVar.b() == 0) {
            if (this.f2435a != null) {
                this.f2435a.a(ayVar.a());
            }
        } else if (this.f2435a != null) {
            this.f2435a.a(null);
        }
    }
}
