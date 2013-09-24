package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TripleTbImageView f1712a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TripleTbImageView tripleTbImageView, String str) {
        this.f1712a = tripleTbImageView;
        this.b = str;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        this.f1712a.b.setTag(this.b);
        this.f1712a.a(this.f1712a.b, cVar);
    }
}
