package com.baidu.tieba.widget.share;

import android.content.Context;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2602a = bVar;
    }

    @Override // com.baidu.tieba.widget.share.a
    public void a() {
        Context context;
        context = this.f2602a.b;
        UtilHelper.a(context, (int) R.string.auth_account_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public void b() {
    }

    @Override // com.baidu.tieba.widget.share.a
    public void c() {
        Context context;
        context = this.f2602a.b;
        UtilHelper.a(context, (int) R.string.share_success);
    }

    @Override // com.baidu.tieba.widget.share.a
    public void d() {
    }
}
