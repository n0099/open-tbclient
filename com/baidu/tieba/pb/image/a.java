package com.baidu.tieba.pb.image;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        com.baidu.tieba.data.w wVar;
        int i;
        int i2;
        com.baidu.tieba.data.w wVar2;
        int i3;
        int i4;
        int i5;
        int i6;
        com.baidu.tieba.data.w wVar3;
        int i7;
        int i8;
        int i9;
        int i10;
        com.baidu.tieba.data.w wVar4;
        int i11;
        int i12 = 0;
        try {
            z = this.a.A;
            if (z) {
                wVar = this.a.F;
                if (wVar != null) {
                    i = this.a.I;
                    if (i > 0) {
                        i11 = this.a.I;
                        i12 = i11 - 1;
                    }
                    i2 = this.a.I;
                    wVar2 = this.a.F;
                    if (i2 >= wVar2.j() - 1) {
                        wVar4 = this.a.F;
                        i4 = wVar4.j() - 1;
                    } else {
                        i3 = this.a.I;
                        i4 = i3 + 1;
                    }
                    UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
                    if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
                        i5 = i4;
                        i6 = i12;
                    } else {
                        i9 = this.a.I;
                        i10 = this.a.I;
                        i5 = i10;
                        i6 = i9;
                    }
                    for (int i13 = i6; i13 <= i5; i13++) {
                        com.baidu.adp.lib.resourceLoader.d a = com.baidu.adp.lib.resourceLoader.d.a();
                        wVar3 = this.a.F;
                        String b = wVar3.g().get(i13).b();
                        b bVar = new b(this);
                        i7 = this.a.S;
                        i8 = this.a.T;
                        a.a(b, 10, bVar, i7, i8, 0, new Object[0]);
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
