package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreActivity moreActivity) {
        this.f1979a = moreActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        if (i == 0) {
            this.f1979a.s();
        } else if (i == 1) {
            this.f1979a.r();
        } else if (i == 2) {
            this.f1979a.q();
        } else if (i == 3) {
            this.f1979a.p();
        } else if (i == 4) {
            this.f1979a.t();
        } else if (i == 6) {
            this.f1979a.o();
        } else if (i == 7) {
            this.f1979a.f();
        } else if (i == 8) {
            this.f1979a.n();
        } else if (i == 5) {
            SystemHelpSettingActivity.a(this.f1979a);
        }
    }
}
