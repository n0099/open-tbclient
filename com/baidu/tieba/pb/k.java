package com.baidu.tieba.pb;

import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.view.ImagePbPagerAdapter;
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
        this.f1533a = imagePbActivity;
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
            z = this.f1533a.C;
            if (z && this.f1533a.H != null) {
                int i3 = this.f1533a.K > 0 ? this.f1533a.K - 1 : 0;
                int k = this.f1533a.K >= this.f1533a.H.k() - 1 ? this.f1533a.H.k() - 1 : this.f1533a.K + 1;
                NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this.f1533a);
                imagePbPagerAdapter = this.f1533a.A;
                imagePbPagerAdapter.d().a();
                if (c != NetWorkCore.NetworkStateInfo.WIFI && c != NetWorkCore.NetworkStateInfo.ThreeG) {
                    i = this.f1533a.K;
                    i2 = this.f1533a.K;
                    z2 = false;
                } else {
                    i = i3;
                    i2 = k;
                    z2 = true;
                }
                imagePbPagerAdapter2 = this.f1533a.A;
                imagePbPagerAdapter2.d().a(z2);
                for (int i4 = i; i4 <= i2; i4++) {
                    imagePbPagerAdapter3 = this.f1533a.A;
                    imagePbPagerAdapter3.d().a(((com.baidu.tieba.data.z) this.f1533a.H.h().get(i4)).b(), new l(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
