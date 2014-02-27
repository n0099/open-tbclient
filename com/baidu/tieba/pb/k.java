package com.baidu.tieba.pb;

import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
final class k implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        com.baidu.tieba.data.ab abVar;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.data.ab abVar2;
        int i4;
        int i5;
        com.baidu.tieba.view.bj bjVar;
        int i6;
        int i7;
        com.baidu.tieba.view.bj bjVar2;
        com.baidu.tieba.view.bj bjVar3;
        com.baidu.tieba.data.ab abVar3;
        int i8;
        int i9;
        com.baidu.tieba.data.ab abVar4;
        int i10;
        try {
            z = this.a.B;
            if (z) {
                abVar = this.a.G;
                if (abVar != null) {
                    i = this.a.J;
                    if (i > 0) {
                        i10 = this.a.J;
                        i2 = i10 - 1;
                    } else {
                        i2 = 0;
                    }
                    i3 = this.a.J;
                    abVar2 = this.a.G;
                    if (i3 >= abVar2.k() - 1) {
                        abVar4 = this.a.G;
                        i5 = abVar4.k() - 1;
                    } else {
                        i4 = this.a.J;
                        i5 = i4 + 1;
                    }
                    UtilHelper.NetworkStateInfo h = UtilHelper.h(this.a);
                    bjVar = this.a.z;
                    bjVar.d().a();
                    if (h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG) {
                        i6 = i5;
                        i7 = i2;
                    } else {
                        i8 = this.a.J;
                        i9 = this.a.J;
                        i6 = i9;
                        i7 = i8;
                    }
                    bjVar2 = this.a.z;
                    bjVar2.d();
                    for (int i11 = i7; i11 <= i6; i11++) {
                        bjVar3 = this.a.z;
                        com.baidu.tieba.util.i d = bjVar3.d();
                        abVar3 = this.a.G;
                        d.b(abVar3.h().get(i11).b(), new l(this));
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
