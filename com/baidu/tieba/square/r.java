package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f2433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f2433a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof s) && (zVar = ((s) tag).b) != null) {
            Activity b = this.f2433a.b();
            String str3 = zVar.b;
            String str4 = zVar.c;
            String str5 = zVar.f2441a;
            str = this.f2433a.d;
            str2 = this.f2433a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
