package com.baidu.tieba.topRec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class p implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.top_cover, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int a() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int d() {
        return 0;
    }
}
