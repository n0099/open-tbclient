package com.baidu.tieba.kn.pk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1251a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str) {
        this.f1251a = lVar;
        this.b = str;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null && this.b.equalsIgnoreCase(str)) {
            this.f1251a.b.a(bVar.f());
        }
    }
}
