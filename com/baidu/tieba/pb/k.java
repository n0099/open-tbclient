package com.baidu.tieba.pb;

import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ImagePbPagerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
        this.f2273a = imagePbActivity;
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
            z = this.f2273a.B;
            if (z && this.f2273a.G != null) {
                int i3 = this.f2273a.J > 0 ? this.f2273a.J - 1 : 0;
                int k = this.f2273a.J >= this.f2273a.G.k() + (-1) ? this.f2273a.G.k() - 1 : this.f2273a.J + 1;
                UtilHelper.NetworkStateInfo g = UtilHelper.g(this.f2273a);
                imagePbPagerAdapter = this.f2273a.z;
                imagePbPagerAdapter.d().a();
                if (g != UtilHelper.NetworkStateInfo.WIFI && g != UtilHelper.NetworkStateInfo.ThreeG) {
                    i = this.f2273a.J;
                    i2 = this.f2273a.J;
                    z2 = false;
                } else {
                    i = i3;
                    i2 = k;
                    z2 = true;
                }
                imagePbPagerAdapter2 = this.f2273a.z;
                imagePbPagerAdapter2.d().a(z2);
                for (int i4 = i; i4 <= i2; i4++) {
                    imagePbPagerAdapter3 = this.f2273a.z;
                    imagePbPagerAdapter3.d().a(this.f2273a.G.h().get(i4).b(), new l(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
