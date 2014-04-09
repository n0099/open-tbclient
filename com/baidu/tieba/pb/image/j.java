package com.baidu.tieba.pb.image;
/* loaded from: classes.dex */
final class j implements t {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.pb.image.t
    public final void a() {
        r rVar;
        com.baidu.tieba.data.u uVar;
        rVar = this.a.b;
        if (rVar == null) {
            ImagePbActivity imagePbActivity = this.a;
            uVar = this.a.F;
            imagePbActivity.a(uVar.k(), 0, 10, false);
        }
    }
}
