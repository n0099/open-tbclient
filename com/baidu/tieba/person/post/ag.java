package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ TripleTbImageView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(TripleTbImageView tripleTbImageView, String str) {
        this.a = tripleTbImageView;
        this.b = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        this.a.d.setTag(this.b);
        this.a.a(this.a.d, bVar);
    }
}
