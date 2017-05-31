package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ca implements com.baidu.adp.lib.e.c<LinearLayout> {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aKp */
    public LinearLayout fL() {
        LinearLayout linearLayout = new LinearLayout(this.enc.getPageContext().getPageActivity());
        linearLayout.setId(w.h.pb_text_voice_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setBaselineAligned(true);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void o(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public LinearLayout p(LinearLayout linearLayout) {
        return linearLayout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public LinearLayout q(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        return linearLayout;
    }
}
