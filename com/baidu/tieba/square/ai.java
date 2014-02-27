package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai implements View.OnClickListener {
    final /* synthetic */ ah a;
    private final /* synthetic */ av b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar, av avVar, int i) {
        this.a = ahVar;
        this.b = avVar;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        String b = this.b.b();
        String a = am.a("forum_topics_recommend", String.valueOf(this.c));
        context = this.a.a;
        UtilHelper.a(context, b, null, a);
    }
}
