package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ HaloView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(HaloView haloView) {
        this.a = haloView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        z = this.a.f;
        if (!z) {
            z2 = this.a.d;
            if (!z2) {
                this.a.e = HaloView.c(this.a) % 4;
            }
            this.a.postDelayed(this, 800L);
            this.a.invalidate();
        }
    }
}
