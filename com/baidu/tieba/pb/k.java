package com.baidu.tieba.pb;

import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ImagePbPagerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
        this.f2181a = imagePbActivity;
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
            z = this.f2181a.B;
            if (z && this.f2181a.G != null) {
                int i3 = this.f2181a.J > 0 ? this.f2181a.J - 1 : 0;
                int k = this.f2181a.J >= this.f2181a.G.k() + (-1) ? this.f2181a.G.k() - 1 : this.f2181a.J + 1;
                UtilHelper.NetworkStateInfo i4 = UtilHelper.i(this.f2181a);
                imagePbPagerAdapter = this.f2181a.z;
                imagePbPagerAdapter.d().a();
                if (i4 != UtilHelper.NetworkStateInfo.WIFI && i4 != UtilHelper.NetworkStateInfo.ThreeG) {
                    i = this.f2181a.J;
                    i2 = this.f2181a.J;
                    z2 = false;
                } else {
                    i = i3;
                    i2 = k;
                    z2 = true;
                }
                imagePbPagerAdapter2 = this.f2181a.z;
                imagePbPagerAdapter2.d().a(z2);
                for (int i5 = i; i5 <= i2; i5++) {
                    imagePbPagerAdapter3 = this.f2181a.z;
                    imagePbPagerAdapter3.d().a(this.f2181a.G.h().get(i5).b(), new l(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
