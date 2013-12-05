package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2372a;
    final /* synthetic */ TripleTbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(TripleTbImageView tripleTbImageView, String str) {
        this.b = tripleTbImageView;
        this.f2372a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        this.b.d.setTag(this.f2372a);
        this.b.a(this.b.d, eVar);
    }
}
