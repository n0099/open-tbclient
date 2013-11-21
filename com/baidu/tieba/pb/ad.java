package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2044a;

    private ad(ImagePbActivity imagePbActivity) {
        this.f2044a = imagePbActivity;
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
            this.f2044a.J = intExtra;
            if (this.f2044a.G != null && intExtra + 5 >= this.f2044a.G.h().size() && this.f2044a.G.h().size() != this.f2044a.G.k()) {
                abVar = this.f2044a.b;
                if (abVar == null) {
                    this.f2044a.a(this.f2044a.G.l(), 0, 10, false);
                }
            }
        } else if (this.f2044a.J == 0 || (this.f2044a.J >= this.f2044a.G.k() - 1 && this.f2044a.G.h().size() == this.f2044a.G.k())) {
            int intExtra2 = intent.getIntExtra(SocialConstants.PARAM_STATE, -1);
            this.f2044a.a(intExtra2);
            com.baidu.tieba.util.bg.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
        }
    }
}
