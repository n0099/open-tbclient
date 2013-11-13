package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aw f2376a;
    final /* synthetic */ int b;
    final /* synthetic */ af c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, aw awVar, int i) {
        this.c = afVar;
        this.f2376a = awVar;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String b = this.f2376a.b();
        String a2 = SquareActivity.a("forum_topics_recommend", String.valueOf(this.b));
        context = this.c.f2375a;
        UtilHelper.a(context, b, null, a2);
    }
}
