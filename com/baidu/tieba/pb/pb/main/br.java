package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class br implements com.baidu.adp.lib.f.c<LinearLayout> {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aIu */
    public LinearLayout dE() {
        LinearLayout linearLayout = new LinearLayout(this.ebT.getPageContext().getPageActivity());
        linearLayout.setId(u.g.pb_text_voice_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setBaselineAligned(true);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public void o(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public LinearLayout p(LinearLayout linearLayout) {
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: e */
    public LinearLayout q(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        return linearLayout;
    }
}
