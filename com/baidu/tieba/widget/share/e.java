package com.baidu.tieba.widget.share;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tieba.widget.share.a
    public void a() {
        Context context;
        context = this.a.b;
        BdUtilHelper.a(context, (int) R.string.auth_account_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public void b() {
    }

    @Override // com.baidu.tieba.widget.share.a
    public void c() {
        Context context;
        context = this.a.b;
        BdUtilHelper.a(context, (int) R.string.share_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public void d() {
    }
}
