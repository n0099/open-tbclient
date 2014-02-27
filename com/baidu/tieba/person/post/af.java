package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ TripleTbImageView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(TripleTbImageView tripleTbImageView, String str) {
        this.a = tripleTbImageView;
        this.b = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        this.a.c.setTag(this.b);
        TripleTbImageView.a(this.a, this.a.c, bVar);
    }
}
