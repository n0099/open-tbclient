package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t a;
    private final /* synthetic */ ap b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ap apVar, int i) {
        this.a = tVar;
        this.b = apVar;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.b.b();
        String a = af.a("carousel_recommend", String.valueOf(this.c));
        bq a2 = bq.a();
        context = this.a.f;
        String[] strArr = new String[3];
        strArr[0] = b;
        strArr[2] = a;
        a2.a(context, strArr);
    }
}
