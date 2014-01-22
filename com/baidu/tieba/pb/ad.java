package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BroadcastReceiver {
    final /* synthetic */ ImagePbActivity a;

    private ad(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ImagePbActivity imagePbActivity, k kVar) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ab abVar;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.a.J = intExtra;
            if (this.a.G != null && intExtra + 5 >= this.a.G.h().size() && this.a.G.h().size() != this.a.G.k()) {
                abVar = this.a.b;
                if (abVar == null) {
                    this.a.a(this.a.G.l(), 0, 10, false);
                }
            }
        } else if (this.a.J == 0 || (this.a.J >= this.a.G.k() - 1 && this.a.G.h().size() == this.a.G.k())) {
            int intExtra2 = intent.getIntExtra(SocialConstants.PARAM_STATE, -1);
            this.a.a(intExtra2);
            com.baidu.adp.lib.g.e.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
        }
    }
}
