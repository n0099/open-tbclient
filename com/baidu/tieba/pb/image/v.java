package com.baidu.tieba.pb.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class v extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity a;

    private v(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(ImagePbActivity imagePbActivity, byte b) {
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
        s sVar;
        com.baidu.tieba.data.u uVar8;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.a.J = intExtra;
            uVar4 = this.a.G;
            if (uVar4 != null) {
                int i3 = intExtra + 5;
                uVar5 = this.a.G;
                if (i3 >= uVar5.h().size()) {
                    uVar6 = this.a.G;
                    int size = uVar6.h().size();
                    uVar7 = this.a.G;
                    if (size != uVar7.k()) {
                        sVar = this.a.b;
                        if (sVar == null) {
                            ImagePbActivity imagePbActivity = this.a;
                            uVar8 = this.a.G;
                            imagePbActivity.a(uVar8.l(), 0, 10, false);
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
        i = this.a.J;
        if (i != 0) {
            i2 = this.a.J;
            uVar = this.a.G;
            if (i2 >= uVar.k() - 1) {
                uVar2 = this.a.G;
                int size2 = uVar2.h().size();
                uVar3 = this.a.G;
                if (size2 != uVar3.k()) {
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
