package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class bi implements com.baidu.adp.lib.f.c<LinearLayout> {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: apF */
    public LinearLayout hk() {
        LinearLayout linearLayout = new LinearLayout(this.cNq.getPageContext().getPageActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setBaselineAligned(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public void l(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public LinearLayout m(LinearLayout linearLayout) {
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public LinearLayout n(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        return linearLayout;
    }
}
