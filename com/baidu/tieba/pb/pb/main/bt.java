package com.baidu.tieba.pb.pb.main;

import android.widget.LinearLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class bt implements com.baidu.adp.lib.f.c<LinearLayout> {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aNm */
    public LinearLayout ez() {
        LinearLayout linearLayout = new LinearLayout(this.eob.getPageContext().getPageActivity());
        linearLayout.setId(t.g.pb_text_voice_layout);
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
