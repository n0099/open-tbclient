package com.baidu.tieba.kn.pk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1781a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, String str) {
        this.b = lVar;
        this.f1781a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null && this.f1781a.equalsIgnoreCase(str)) {
            this.b.b.b(eVar.f());
        }
    }
}
