package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f1751a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof q) && (sVar = ((q) tag).b) != null) {
            Activity b = this.f1751a.b();
            String str3 = sVar.b;
            String str4 = sVar.c;
            String str5 = sVar.f1754a;
            str = this.f1751a.d;
            str2 = this.f1751a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
