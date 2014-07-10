package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac a;
    private final /* synthetic */ ap b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, ap apVar, int i) {
        this.a = acVar;
        this.b = apVar;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.b.b();
        String a = af.a("forum_topics_recommend", String.valueOf(this.c));
        bq a2 = bq.a();
        context = this.a.a;
        String[] strArr = new String[3];
        strArr[0] = b;
        strArr[2] = a;
        a2.a(context, strArr);
    }
}
