package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1954a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreActivity moreActivity) {
        this.f1954a = moreActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        if (i == 0) {
            this.f1954a.k();
        } else if (i == 1) {
            this.f1954a.j();
        } else if (i == 2) {
            this.f1954a.i();
        } else if (i == 3) {
            this.f1954a.h();
        } else if (i == 4) {
            this.f1954a.l();
        } else if (i == 6) {
            this.f1954a.g();
        } else if (i == 7) {
            this.f1954a.e();
        } else if (i == 8) {
            this.f1954a.f();
        } else if (i == 5) {
            SystemHelpSettingActivity.a(this.f1954a);
        }
    }
}
