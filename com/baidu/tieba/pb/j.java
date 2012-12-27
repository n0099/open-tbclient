package com.baidu.tieba.pb;

import com.baidu.tieba.view.ImagePbPagerAdapter;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        ImagePbPagerAdapter imagePbPagerAdapter;
        int i;
        int i2;
        boolean z2;
        ImagePbPagerAdapter imagePbPagerAdapter2;
        ImagePbPagerAdapter imagePbPagerAdapter3;
        try {
            z = this.a.A;
            if (!z || this.a.F == null) {
                return;
            }
            int i3 = this.a.I > 0 ? this.a.I - 1 : 0;
            int k = this.a.I >= this.a.F.k() + (-1) ? this.a.F.k() - 1 : this.a.I + 1;
            com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
            imagePbPagerAdapter = this.a.y;
            imagePbPagerAdapter.d().a();
            if (c == com.baidu.tieba.c.z.WIFI || c == com.baidu.tieba.c.z.ThreeG) {
                i = i3;
                i2 = k;
                z2 = true;
            } else {
                i = this.a.I;
                i2 = this.a.I;
                z2 = false;
            }
            imagePbPagerAdapter2 = this.a.y;
            imagePbPagerAdapter2.d().a(z2);
            for (int i4 = i; i4 <= i2; i4++) {
                imagePbPagerAdapter3 = this.a.y;
                imagePbPagerAdapter3.d().a(((com.baidu.tieba.a.t) this.a.F.h().get(i4)).b(), new k(this));
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
