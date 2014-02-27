package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
final class al implements View.OnClickListener {
    final /* synthetic */ aj a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar, int i, String str) {
        this.a = ajVar;
        this.b = i;
        this.c = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        String a = am.a("post_recommend", String.valueOf(this.b));
        context = this.a.b;
        NewPbActivity.a(context, this.c, "", a);
    }
}
