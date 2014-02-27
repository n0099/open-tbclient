package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements View.OnClickListener {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ab abVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof s) && (abVar = ((s) tag).b) != null) {
            Activity b = this.a.b();
            String str3 = abVar.b;
            String str4 = abVar.c;
            String str5 = abVar.a;
            str = this.a.d;
            str2 = this.a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
