package com.baidu.tieba.pb.view;

import android.widget.ImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ l eCy;
    private final /* synthetic */ int val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, int i) {
        this.eCy = lVar;
        this.val$type = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        int i = 0;
        imageView = this.eCy.eCs;
        imageView.setVisibility(0);
        if (this.val$type == 1) {
            imageView6 = this.eCy.eCs;
            imageView7 = this.eCy.eCs;
            imageView6.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(imageView7.getContext(), w.f.ds70));
            i = w.b.full_screen_big_praise;
        } else if (this.val$type == 4) {
            imageView2 = this.eCy.eCs;
            imageView2.setPadding(0, 0, 0, 0);
            i = w.b.full_screen_big_trample;
        }
        imageView3 = this.eCy.eCs;
        imageView3.invalidate();
        imageView4 = this.eCy.eCs;
        com.baidu.tieba.pb.pb.main.view.c b = com.baidu.tieba.pb.pb.main.view.c.b(imageView4, i, 20, 1);
        b.a(new s(this));
        imageView5 = this.eCy.eCs;
        imageView5.setTag(b);
        b.start();
    }
}
