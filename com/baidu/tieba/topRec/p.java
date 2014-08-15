package com.baidu.tieba.topRec;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class p implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.a.a);
        imageView.setBackgroundResource(t.pic_emotion03);
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
