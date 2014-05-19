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
        com.baidu.tieba.data.u uVar;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.data.u uVar2;
        int i4;
        int i5;
        ac acVar;
        int i6;
        int i7;
        boolean z2;
        ac acVar2;
        ac acVar3;
        com.baidu.tieba.data.u uVar3;
        int i8;
        int i9;
        com.baidu.tieba.data.u uVar4;
        int i10;
        try {
            z = this.a.A;
            if (z) {
                uVar = this.a.F;
                if (uVar != null) {
                    i = this.a.I;
                    if (i > 0) {
                        i10 = this.a.I;
                        i2 = i10 - 1;
                    } else {
                        i2 = 0;
                    }
                    i3 = this.a.I;
                    uVar2 = this.a.F;
                    if (i3 >= uVar2.j() - 1) {
                        uVar4 = this.a.F;
                        i5 = uVar4.j() - 1;
                    } else {
                        i4 = this.a.I;
                        i5 = i4 + 1;
                    }
                    UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a);
                    acVar = this.a.y;
                    acVar.d().a();
                    if (netStatusInfo != UtilHelper.NetworkStateInfo.WIFI && netStatusInfo != UtilHelper.NetworkStateInfo.ThreeG) {
                        i8 = this.a.I;
                        i9 = this.a.I;
                        i6 = i8;
                        i7 = i9;
                        z2 = false;
                    } else {
                        i6 = i2;
                        i7 = i5;
                        z2 = true;
                    }
                    acVar2 = this.a.y;
                    acVar2.d().a(z2);
                    for (int i11 = i6; i11 <= i7; i11++) {
                        acVar3 = this.a.y;
                        com.baidu.tbadk.editortool.ab d = acVar3.d();
                        uVar3 = this.a.F;
                        d.b(uVar3.g().get(i11).b(), new b(this));
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e("ImagePbActivity", "mGetImageRunnble.run", "error = " + e.getMessage());
        }
    }
}
