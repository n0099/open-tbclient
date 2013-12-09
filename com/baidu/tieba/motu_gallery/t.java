package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2130a;
    final /* synthetic */ a b;
    final /* synthetic */ s c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, w wVar, a aVar) {
        this.c = sVar;
        this.f2130a = wVar;
        this.b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        TextView textView;
        this.c.b.f2128a.f2111a.b(this.c.b.f2128a, this.f2130a.getUri());
        this.b.setIsSelected(false);
        linearLayout = this.c.b.f2128a.m;
        linearLayout.removeView(view);
        textView = this.c.b.f2128a.o;
        textView.setText(this.c.b.f2128a.f2111a.e(this.c.b.f2128a));
    }
}
