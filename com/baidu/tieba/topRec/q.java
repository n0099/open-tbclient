package com.baidu.tieba.topRec;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class q implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.a.a);
        imageView.setBackgroundResource(R.drawable.lead_metadata);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int c() {
        return -100;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int d() {
        return -30;
    }
}
