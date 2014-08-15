package com.baidu.tieba.pb.main;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class x implements com.baidu.adp.lib.d.c<LinearLayout> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.a);
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
