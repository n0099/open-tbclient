package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class cb implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return -22;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return 40;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.a.a);
        imageView.setBackgroundResource(R.drawable.bg_center_guide);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }
}
