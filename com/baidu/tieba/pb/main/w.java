package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class w implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        PbActivity.a(this.a, bVar, str, z);
        PbActivity.b(this.a, bVar, str, z);
    }
}
