package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2377a;
    final /* synthetic */ String b;
    final /* synthetic */ HotThreadPagerAdapter c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(HotThreadPagerAdapter hotThreadPagerAdapter, int i, String str) {
        this.c = hotThreadPagerAdapter;
        this.f2377a = i;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String a2 = SquareActivity.a("post_recommend", String.valueOf(this.f2377a));
        context = this.c.c;
        NewPbActivity.a(context, this.b, "", a2);
    }
}
