package com.baidu.tieba.pb.image;
/* loaded from: classes.dex */
class j implements t {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.pb.image.t
    public void a(int i, int i2, int i3) {
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
