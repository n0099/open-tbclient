package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2022a;
    final /* synthetic */ a b;
    final /* synthetic */ s c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, w wVar, a aVar) {
        this.c = sVar;
        this.f2022a = wVar;
        this.b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        TextView textView;
        this.c.b.f2020a.f2003a.b(this.c.b.f2020a, this.f2022a.getUri());
        this.b.setIsSelected(false);
        linearLayout = this.c.b.f2020a.m;
        linearLayout.removeView(view);
        textView = this.c.b.f2020a.o;
        textView.setText(this.c.b.f2020a.f2003a.e(this.c.b.f2020a));
    }
}
