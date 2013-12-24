package com.baidu.tieba.more;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ac {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.tieba.more.ac
    public void a(int i) {
        if (i == 0) {
            this.a.k();
        } else if (i == 1) {
            this.a.j();
        } else if (i == 2) {
            this.a.i();
        } else if (i == 3) {
            this.a.h();
        } else if (i == 4) {
            this.a.l();
        } else if (i == 6) {
            this.a.g();
        } else if (i == 7) {
            this.a.e();
        } else if (i == 8) {
            this.a.f();
        } else if (i == 5) {
            SystemHelpSettingActivity.a(this.a);
        } else if (i == 9) {
            this.a.m();
        }
    }
}
