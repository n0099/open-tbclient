package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        String str;
        String str2;
        Object tag = view.getTag();
        if ((tag instanceof n) && (wVar = ((n) tag).b) != null) {
            Activity b = this.a.b();
            String str3 = wVar.b;
            String str4 = wVar.c;
            String str5 = wVar.a;
            str = this.a.d;
            str2 = this.a.e;
            ForumListActivity.a(b, str3, str4, str5, str, str2);
        }
    }
}
