package com.baidu.tieba.pb.pb.sub;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
class o implements com.baidu.adp.lib.f.c<LinearLayout> {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: alC */
    public LinearLayout hc() {
        LinearLayout linearLayout = new LinearLayout(this.cLc.getPageContext().getPageActivity());
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
    /* renamed from: g */
    public void l(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: h */
    public LinearLayout m(LinearLayout linearLayout) {
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: i */
    public LinearLayout n(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        return linearLayout;
    }
}
