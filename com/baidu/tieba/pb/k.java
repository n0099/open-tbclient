package com.baidu.tieba.pb;

import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ImagePbPagerAdapter;
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
        this.f1621a = imagePbActivity;
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
            z = this.f1621a.C;
            if (z && this.f1621a.H != null) {
                int i3 = this.f1621a.K > 0 ? this.f1621a.K - 1 : 0;
                int k = this.f1621a.K < this.f1621a.H.k() - 1 ? this.f1621a.K + 1 : this.f1621a.H.k() - 1;
                UtilHelper.NetworkStateInfo i4 = UtilHelper.i(this.f1621a);
                imagePbPagerAdapter = this.f1621a.A;
                imagePbPagerAdapter.d().a();
                if (i4 != UtilHelper.NetworkStateInfo.WIFI && i4 != UtilHelper.NetworkStateInfo.ThreeG) {
                    i = this.f1621a.K;
                    i2 = this.f1621a.K;
                    z2 = false;
                } else {
                    i = i3;
                    i2 = k;
                    z2 = true;
                }
                imagePbPagerAdapter2 = this.f1621a.A;
                imagePbPagerAdapter2.d().a(z2);
                for (int i5 = i; i5 <= i2; i5++) {
                    imagePbPagerAdapter3 = this.f1621a.A;
                    imagePbPagerAdapter3.d().a(this.f1621a.H.h().get(i5).b(), new l(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
