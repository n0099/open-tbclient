package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bv implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.a = buVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            this.a.o.setImageResource(0);
            dVar.a(this.a.o);
        }
        this.a.l.c();
    }
}
