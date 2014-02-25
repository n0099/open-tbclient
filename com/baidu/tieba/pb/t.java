package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class t implements ad {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // com.baidu.tieba.pb.ad
    public void a(int i, int i2, int i3) {
        ab abVar;
        com.baidu.tieba.data.ab abVar2;
        abVar = this.a.b;
        if (abVar == null) {
            ImagePbActivity imagePbActivity = this.a;
            abVar2 = this.a.G;
            imagePbActivity.a(abVar2.l(), 0, 10, false);
        }
    }
}
