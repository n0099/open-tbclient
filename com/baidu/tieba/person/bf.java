package com.baidu.tieba.person;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f2236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f2236a = beVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        if (eVar != null) {
            this.f2236a.n.setImageResource(0);
            eVar.a(this.f2236a.n);
        }
    }
}
