package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class p implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2186a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ImagePbActivity imagePbActivity) {
        this.f2186a = imagePbActivity;
    }

    @Override // com.baidu.tieba.pb.ac
    public void a(int i, int i2, int i3) {
        ab abVar;
        abVar = this.f2186a.b;
        if (abVar == null) {
            this.f2186a.a(this.f2186a.G.l(), 0, 10, false);
        }
    }
}
