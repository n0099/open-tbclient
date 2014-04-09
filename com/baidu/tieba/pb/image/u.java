package com.baidu.tieba.pb.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class u extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity a;

    private u(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(ImagePbActivity imagePbActivity, byte b) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i;
        int i2;
        com.baidu.tieba.data.u uVar;
        com.baidu.tieba.data.u uVar2;
        com.baidu.tieba.data.u uVar3;
        com.baidu.tieba.data.u uVar4;
        com.baidu.tieba.data.u uVar5;
        com.baidu.tieba.data.u uVar6;
        com.baidu.tieba.data.u uVar7;
        r rVar;
        com.baidu.tieba.data.u uVar8;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.a.I = intExtra;
            uVar4 = this.a.F;
            if (uVar4 != null) {
                int i3 = intExtra + 5;
                uVar5 = this.a.F;
                if (i3 >= uVar5.g().size()) {
                    uVar6 = this.a.F;
                    int size = uVar6.g().size();
                    uVar7 = this.a.F;
                    if (size != uVar7.j()) {
                        rVar = this.a.b;
                        if (rVar == null) {
                            ImagePbActivity imagePbActivity = this.a;
                            uVar8 = this.a.F;
                            imagePbActivity.a(uVar8.k(), 0, 10, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        i = this.a.I;
        if (i != 0) {
            i2 = this.a.I;
            uVar = this.a.F;
            if (i2 >= uVar.j() - 1) {
                uVar2 = this.a.F;
                int size2 = uVar2.g().size();
                uVar3 = this.a.F;
                if (size2 != uVar3.j()) {
                    return;
                }
            } else {
                return;
            }
        }
        int intExtra2 = intent.getIntExtra("state", -1);
        this.a.a(intExtra2);
        com.baidu.adp.lib.util.f.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
    }
}
