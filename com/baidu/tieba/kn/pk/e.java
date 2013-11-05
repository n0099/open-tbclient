package com.baidu.tieba.kn.pk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1772a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, String str) {
        this.b = cVar;
        this.f1772a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.f1772a.equalsIgnoreCase(str)) {
            this.b.b.b(eVar.f());
        }
    }
}
