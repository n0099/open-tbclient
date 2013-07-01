package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1439a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f1439a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof o) && (qVar = ((o) tag).b) != null) {
            Activity b = this.f1439a.b();
            String str3 = qVar.b;
            String str4 = qVar.c;
            String str5 = qVar.f1441a;
            str = this.f1439a.d;
            str2 = this.f1439a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
