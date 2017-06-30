package com.baidu.tieba.pb.view;

import android.widget.ImageView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ l eLV;
    private final /* synthetic */ int val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, int i) {
        this.eLV = lVar;
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
        imageView = this.eLV.eLP;
        imageView.setVisibility(0);
        if (this.val$type == 1) {
            imageView6 = this.eLV.eLP;
            imageView7 = this.eLV.eLP;
            imageView6.setPadding(0, 0, 0, com.baidu.adp.lib.util.k.g(imageView7.getContext(), w.f.ds70));
            i = w.b.full_screen_big_praise;
        } else if (this.val$type == 4) {
            imageView2 = this.eLV.eLP;
            imageView2.setPadding(0, 0, 0, 0);
            i = w.b.full_screen_big_trample;
        }
        imageView3 = this.eLV.eLP;
        imageView3.invalidate();
        imageView4 = this.eLV.eLP;
        com.baidu.tieba.pb.pb.main.view.c b = com.baidu.tieba.pb.pb.main.view.c.b(imageView4, i, 20, 1);
        b.a(new s(this));
        imageView5 = this.eLV.eLP;
        imageView5.setTag(b);
        b.start();
    }
}
