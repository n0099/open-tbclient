package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof o) && (qVar = ((o) tag).b) != null) {
            Activity b = this.a.b();
            String str3 = qVar.b;
            String str4 = qVar.c;
            String str5 = qVar.a;
            str = this.a.d;
            str2 = this.a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
