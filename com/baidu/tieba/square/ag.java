package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ au f2360a;
    final /* synthetic */ int b;
    final /* synthetic */ af c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, au auVar, int i) {
        this.c = afVar;
        this.f2360a = auVar;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.f2360a.b();
        String a2 = SquareActivity.a("forum_topics_recommend", String.valueOf(this.b));
        context = this.c.f2359a;
        UtilHelper.a(context, b, null, a2);
    }
}
