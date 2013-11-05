package com.baidu.tieba.pb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2041a;

    private ae(ImagePbActivity imagePbActivity) {
        this.f2041a = imagePbActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(ImagePbActivity imagePbActivity, k kVar) {
        this(imagePbActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ac acVar;
        int intExtra = intent.getIntExtra("index", -1);
        if (intExtra >= 0) {
            this.f2041a.K = intExtra;
            if (this.f2041a.H != null && intExtra + 5 >= this.f2041a.H.h().size() && this.f2041a.H.h().size() != this.f2041a.H.k()) {
                acVar = this.f2041a.f2031a;
                if (acVar == null) {
                    this.f2041a.a(this.f2041a.H.l(), 0, 10, false);
                }
            }
        } else if (this.f2041a.K == 0 || (this.f2041a.K >= this.f2041a.H.k() - 1 && this.f2041a.H.h().size() == this.f2041a.H.k())) {
            int intExtra2 = intent.getIntExtra(SocialConstants.PARAM_STATE, -1);
            this.f2041a.a_(intExtra2);
            com.baidu.tieba.util.be.a(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(intExtra2));
        }
    }
}
