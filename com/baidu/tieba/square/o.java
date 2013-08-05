package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1733a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f1733a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof p) && (rVar = ((p) tag).b) != null) {
            Activity b = this.f1733a.b();
            String str3 = rVar.b;
            String str4 = rVar.c;
            String str5 = rVar.f1736a;
            str = this.f1733a.d;
            str2 = this.f1733a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
