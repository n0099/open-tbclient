package com.baidu.tieba.kn.pk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1293a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str) {
        this.f1293a = tVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        if (cVar != null && this.b.equalsIgnoreCase(str)) {
            this.f1293a.b.a(cVar.f());
        }
    }
}
