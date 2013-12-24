package com.baidu.tieba.widget.share;

import android.content.Context;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tieba.widget.share.a
    public void a() {
        Context context;
        context = this.a.b;
        com.baidu.adp.lib.h.g.a(context, (int) R.string.auth_account_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public void b() {
    }

    @Override // com.baidu.tieba.widget.share.a
    public void c() {
        Context context;
        context = this.a.b;
        com.baidu.adp.lib.h.g.a(context, (int) R.string.share_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public void d() {
    }
}
