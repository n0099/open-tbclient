package com.baidu.tieba.pb;

import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class bh implements com.baidu.adp.lib.d.c<LinearLayout> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setBaselineAligned(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(LinearLayout linearLayout) {
        linearLayout.removeAllViews();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ LinearLayout b(LinearLayout linearLayout) {
        return linearLayout;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.removeAllViews();
        return linearLayout2;
    }
}
