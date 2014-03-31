package com.baidu.tieba.pb.image;
/* loaded from: classes.dex */
final class k implements u {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.pb.image.u
    public final void a() {
        s sVar;
        com.baidu.tieba.data.u uVar;
        sVar = this.a.b;
        if (sVar == null) {
            ImagePbActivity imagePbActivity = this.a;
            uVar = this.a.G;
            imagePbActivity.a(uVar.l(), 0, 10, false);
        }
    }
}
