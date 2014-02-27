package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
final class t implements View.OnClickListener {
    final /* synthetic */ AppsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(AppsActivity appsActivity) {
        this.a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
