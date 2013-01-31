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
            z = this.a.C;
            if (z && this.a.H != null) {
                int i3 = this.a.K > 0 ? this.a.K - 1 : 0;
                int k = this.a.K >= this.a.H.k() - 1 ? this.a.H.k() - 1 : this.a.K + 1;
                com.baidu.tieba.c.z c = com.baidu.tieba.c.w.c(this.a);
                imagePbPagerAdapter = this.a.A;
                imagePbPagerAdapter.d().a();
                if (c != com.baidu.tieba.c.z.WIFI && c != com.baidu.tieba.c.z.ThreeG) {
                    i = this.a.K;
                    i2 = this.a.K;
                    z2 = false;
                } else {
                    i = i3;
                    i2 = k;
                    z2 = true;
                }
                imagePbPagerAdapter2 = this.a.A;
                imagePbPagerAdapter2.d().a(z2);
                for (int i4 = i; i4 <= i2; i4++) {
                    imagePbPagerAdapter3 = this.a.A;
                    imagePbPagerAdapter3.d().a(((com.baidu.tieba.a.u) this.a.H.h().get(i4)).b(), new k(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
