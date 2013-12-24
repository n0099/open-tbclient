package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ au a;
    final /* synthetic */ int b;
    final /* synthetic */ af c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, au auVar, int i) {
        this.c = afVar;
        this.a = auVar;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.a.b();
        String a = SquareActivity.a("forum_topics_recommend", String.valueOf(this.b));
        context = this.c.a;
        UtilHelper.a(context, b, null, a);
    }
}
