package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f2065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreActivity moreActivity) {
        this.f2065a = moreActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        if (i == 0) {
            this.f2065a.k();
        } else if (i == 1) {
            this.f2065a.j();
        } else if (i == 2) {
            this.f2065a.i();
        } else if (i == 3) {
            this.f2065a.h();
        } else if (i == 4) {
            this.f2065a.l();
        } else if (i == 6) {
            this.f2065a.g();
        } else if (i == 7) {
            this.f2065a.e();
        } else if (i == 8) {
            this.f2065a.f();
        } else if (i == 5) {
            SystemHelpSettingActivity.a(this.f2065a);
        }
    }
}
