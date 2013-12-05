package com.baidu.tieba.pb;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class bh implements com.baidu.adp.lib.d.c<LinearLayout> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(NewPbActivity newPbActivity) {
        this.f2182a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f2182a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setBaselineAligned(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public LinearLayout b(LinearLayout linearLayout) {
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public LinearLayout c(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        return linearLayout;
    }
}
