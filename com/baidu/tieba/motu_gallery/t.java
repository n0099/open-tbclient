package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ w a;
    final /* synthetic */ a b;
    final /* synthetic */ s c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, w wVar, a aVar) {
        this.c = sVar;
        this.a = wVar;
        this.b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        TextView textView;
        this.c.b.a.a.b(this.c.b.a, this.a.getUri());
        this.b.setIsSelected(false);
        linearLayout = this.c.b.a.m;
        linearLayout.removeView(view);
        textView = this.c.b.a.o;
        textView.setText(this.c.b.a.a.e(this.c.b.a));
    }
}
