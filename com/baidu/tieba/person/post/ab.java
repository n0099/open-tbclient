package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ TripleTbImageView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TripleTbImageView tripleTbImageView, String str) {
        this.a = tripleTbImageView;
        this.b = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        this.a.b.setTag(this.b);
        TripleTbImageView.a(this.a, this.a.b, bVar);
    }
}
