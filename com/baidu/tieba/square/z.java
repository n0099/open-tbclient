package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y a;
    private final /* synthetic */ av b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, av avVar, int i) {
        this.a = yVar;
        this.b = avVar;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.b.b();
        String a = am.a("carousel_recommend", String.valueOf(this.c));
        context = this.a.f;
        UtilHelper.a(context, b, null, a);
    }
}
