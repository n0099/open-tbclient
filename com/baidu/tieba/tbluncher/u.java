package com.baidu.tieba.tbluncher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.aa;
/* loaded from: classes.dex */
public final class u implements com.baidu.tbadk.core.d.a {
    @Override // com.baidu.tbadk.core.d.a
    public final void a(Context context, int i) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2015001, new aa(context).a(i, false)));
    }

    @Override // com.baidu.tbadk.core.d.a
    public final void a(Context context) {
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
            a(context, 1);
        } else {
            a(context, 0);
        }
    }

    @Override // com.baidu.tbadk.core.d.a
    public final void a(Context context, int i, boolean z) {
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        aa aaVar = new aa(context);
        Intent d = aaVar.d();
        d.setFlags(603979776);
        d.putExtra("refresh_all", true);
        if (i >= 0) {
            d.putExtra("locate_type", i);
        }
        if (z) {
            d.addFlags(268435456);
        }
        d.putExtra("close_dialog", true);
        a.a(new com.baidu.adp.framework.message.a(2015001, aaVar));
    }

    @Override // com.baidu.tbadk.core.d.a
    public final Class<?> a() {
        return MainTabActivity.class;
    }

    @Override // com.baidu.tbadk.core.d.a
    public final String b() {
        return MainTabActivity.class.getName();
    }
}
