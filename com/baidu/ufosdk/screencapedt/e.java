package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import android.view.View;
/* loaded from: classes21.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ ScreenCapEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ScreenCapEditActivity screenCapEditActivity) {
        this.a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        z = this.a.I;
        if (z) {
            z2 = this.a.K;
            if (z2) {
                this.a.setResult(-77, new Intent());
            }
        }
        this.a.finish();
    }
}
