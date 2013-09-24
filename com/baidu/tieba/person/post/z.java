package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TripleTbImageView f1731a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TripleTbImageView tripleTbImageView, String str) {
        this.f1731a = tripleTbImageView;
        this.b = str;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        this.f1731a.c.setTag(this.b);
        this.f1731a.a(this.f1731a.c, cVar);
    }
}
