package com.baidu.tieba.widget.share;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements a {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tieba.widget.share.a
    public final void a() {
        Context context;
        context = this.a.b;
        BdUtilHelper.a(context, (int) R.string.auth_account_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public final void b() {
        Context context;
        context = this.a.b;
        BdUtilHelper.a(context, (int) R.string.share_success);
    }
}
