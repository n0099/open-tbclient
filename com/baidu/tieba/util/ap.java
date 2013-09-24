package com.baidu.tieba.util;
/* loaded from: classes.dex */
class ap implements com.baidu.tieba.model.al {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1905a;
    private final /* synthetic */ aq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar, aq aqVar) {
        this.f1905a = alVar;
        this.b = aqVar;
    }

    @Override // com.baidu.tieba.model.al
    public void a() {
    }

    @Override // com.baidu.tieba.model.al
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
