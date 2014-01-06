package com.baidu.tieba.pb;

import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.ImagePbPagerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
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
            z = this.a.B;
            if (z && this.a.G != null) {
                int i3 = this.a.J > 0 ? this.a.J - 1 : 0;
                int k = this.a.J >= this.a.G.k() + (-1) ? this.a.G.k() - 1 : this.a.J + 1;
                UtilHelper.NetworkStateInfo g = UtilHelper.g(this.a);
                imagePbPagerAdapter = this.a.z;
                imagePbPagerAdapter.d().a();
                if (g != UtilHelper.NetworkStateInfo.WIFI && g != UtilHelper.NetworkStateInfo.ThreeG) {
                    i = this.a.J;
                    i2 = this.a.J;
                    z2 = false;
                } else {
                    i = i3;
                    i2 = k;
                    z2 = true;
                }
                imagePbPagerAdapter2 = this.a.z;
                imagePbPagerAdapter2.d().a(z2);
                for (int i4 = i; i4 <= i2; i4++) {
                    imagePbPagerAdapter3 = this.a.z;
                    imagePbPagerAdapter3.d().a(this.a.G.h().get(i4).b(), new l(this));
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
