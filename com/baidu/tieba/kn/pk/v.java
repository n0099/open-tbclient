package com.baidu.tieba.kn.pk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1789a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str) {
        this.b = tVar;
        this.f1789a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.f1789a.equalsIgnoreCase(str)) {
            this.b.b.b(eVar.f());
        }
    }
}
