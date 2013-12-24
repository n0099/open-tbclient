package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ HotThreadPagerAdapter c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(HotThreadPagerAdapter hotThreadPagerAdapter, int i, String str) {
        this.c = hotThreadPagerAdapter;
        this.a = i;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        String a = SquareActivity.a("post_recommend", String.valueOf(this.a));
        context = this.c.c;
        NewPbActivity.a(context, this.b, "", a);
    }
}
