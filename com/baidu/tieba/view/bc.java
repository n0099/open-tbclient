package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bc implements Runnable {
    final /* synthetic */ HaloView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(HaloView haloView) {
        this.a = haloView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        int i;
        z = this.a.f;
        if (!z) {
            z2 = this.a.d;
            if (!z2) {
                HaloView haloView = this.a;
                HaloView haloView2 = this.a;
                i = haloView2.e;
                int i2 = i + 1;
                haloView2.e = i2;
                haloView.e = i2 % 4;
            }
            this.a.postDelayed(this, 800L);
            this.a.invalidate();
        }
    }
}
