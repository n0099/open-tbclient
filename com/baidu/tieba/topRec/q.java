package com.baidu.tieba.topRec;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class q implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.f1878a = oVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.f1878a.f1876a);
        imageView.setBackgroundResource(R.drawable.lead_metadata);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return -100;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return -30;
    }
}
