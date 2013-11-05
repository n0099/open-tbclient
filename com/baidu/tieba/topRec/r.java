package com.baidu.tieba.topRec;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class r implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f2400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.f2400a = pVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.f2400a.f2398a);
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
