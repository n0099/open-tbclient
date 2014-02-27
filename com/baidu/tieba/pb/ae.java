package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
final class ae extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity a;

    private ae(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(ImagePbActivity imagePbActivity, byte b) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int i;
        int i2;
        com.baidu.tieba.data.ab abVar;
        com.baidu.tieba.data.ab abVar2;
        com.baidu.tieba.data.ab abVar3;
        com.baidu.tieba.data.ab abVar4;
        com.baidu.tieba.data.ab abVar5;
        com.baidu.tieba.data.ab abVar6;
        com.baidu.tieba.data.ab abVar7;
        ab abVar8;
        com.baidu.tieba.data.ab abVar9;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.a.J = intExtra;
            abVar4 = this.a.G;
            if (abVar4 != null) {
                int i3 = intExtra + 5;
                abVar5 = this.a.G;
                if (i3 >= abVar5.h().size()) {
                    abVar6 = this.a.G;
                    int size = abVar6.h().size();
                    abVar7 = this.a.G;
                    if (size != abVar7.k()) {
                        abVar8 = this.a.b;
                        if (abVar8 == null) {
                            ImagePbActivity imagePbActivity = this.a;
                            abVar9 = this.a.G;
                            imagePbActivity.a(abVar9.l(), 0, 10, false);
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
            abVar = this.a.G;
            if (i2 >= abVar.k() - 1) {
                abVar2 = this.a.G;
                int size2 = abVar2.h().size();
                abVar3 = this.a.G;
                if (size2 != abVar3.k()) {
                    return;
                }
            } else {
                return;
            }
        }
        int intExtra2 = intent.getIntExtra(SocialConstants.PARAM_STATE, -1);
        this.a.a(intExtra2);
        com.baidu.adp.lib.util.e.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
    }
}
