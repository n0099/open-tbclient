package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TripleTbImageView f1713a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TripleTbImageView tripleTbImageView, String str) {
        this.f1713a = tripleTbImageView;
        this.b = str;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        this.f1713a.c.setTag(this.b);
        this.f1713a.a(this.f1713a.c, cVar);
    }
}
