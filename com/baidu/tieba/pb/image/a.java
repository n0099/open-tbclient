package com.baidu.tieba.pb.image;

import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
final class a implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        com.baidu.tieba.data.u uVar;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.data.u uVar2;
        int i4;
        int i5;
        ad adVar;
        int i6;
        int i7;
        ad adVar2;
        ad adVar3;
        com.baidu.tieba.data.u uVar3;
        int i8;
        int i9;
        com.baidu.tieba.data.u uVar4;
        int i10;
        try {
            z = this.a.B;
            if (z) {
                uVar = this.a.G;
                if (uVar != null) {
                    i = this.a.J;
                    if (i > 0) {
                        i10 = this.a.J;
                        i2 = i10 - 1;
                    } else {
                        i2 = 0;
                    }
                    i3 = this.a.J;
                    uVar2 = this.a.G;
                    if (i3 >= uVar2.k() - 1) {
                        uVar4 = this.a.G;
                        i5 = uVar4.k() - 1;
                    } else {
                        i4 = this.a.J;
                        i5 = i4 + 1;
                    }
                    UtilHelper.NetworkStateInfo d = UtilHelper.d(this.a);
                    adVar = this.a.z;
                    adVar.d().a();
                    if (d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG) {
                        i6 = i5;
                        i7 = i2;
                    } else {
                        i8 = this.a.J;
                        i9 = this.a.J;
                        i6 = i9;
                        i7 = i8;
                    }
                    adVar2 = this.a.z;
                    adVar2.d();
                    for (int i11 = i7; i11 <= i6; i11++) {
                        adVar3 = this.a.z;
                        com.baidu.tbadk.editortool.aa d2 = adVar3.d();
                        uVar3 = this.a.G;
                        d2.b(uVar3.h().get(i11).b(), new b(this));
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
