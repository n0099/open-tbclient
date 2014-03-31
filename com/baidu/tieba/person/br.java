package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br implements com.baidu.adp.widget.ListView.a {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public final void b() {
        af afVar;
        if (!this.a.isIsloading()) {
            afVar = this.a.mHeadView;
            afVar.d();
            this.a.setIsloading(true);
            this.a.refresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.a
    public final void a(float f) {
        af afVar;
        afVar = this.a.mHeadView;
        afVar.a(f);
    }

    @Override // com.baidu.adp.widget.ListView.a
    public final void a() {
        af afVar;
        afVar = this.a.mHeadView;
        afVar.b();
    }
}
