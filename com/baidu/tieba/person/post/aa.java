package com.baidu.tieba.person.post;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ String a;
    final /* synthetic */ TripleTbImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TripleTbImageView tripleTbImageView, String str) {
        this.b = tripleTbImageView;
        this.a = str;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        this.b.b.setTag(this.a);
        this.b.a(this.b.b, eVar);
    }
}
