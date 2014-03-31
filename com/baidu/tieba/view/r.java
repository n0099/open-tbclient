package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes.dex */
final class r extends Handler {
    final /* synthetic */ GoOnAnimView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GoOnAnimView goOnAnimView) {
        this.a = goOnAnimView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        int i2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        int i3;
        Handler handler;
        Handler handler2;
        super.handleMessage(message);
        GoOnAnimView goOnAnimView = this.a;
        i = goOnAnimView.e;
        goOnAnimView.e = i % 4;
        i2 = this.a.e;
        switch (i2) {
            case 0:
                imageView10 = this.a.b;
                imageView10.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_1);
                imageView11 = this.a.c;
                imageView11.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_2);
                imageView12 = this.a.d;
                imageView12.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_3);
                break;
            case 1:
                imageView7 = this.a.b;
                imageView7.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_3);
                imageView8 = this.a.c;
                imageView8.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_1);
                imageView9 = this.a.d;
                imageView9.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_2);
                break;
            case 2:
                imageView4 = this.a.b;
                imageView4.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_2);
                imageView5 = this.a.c;
                imageView5.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_3);
                imageView6 = this.a.d;
                imageView6.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_1);
                break;
            case 3:
                imageView = this.a.b;
                imageView.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_2);
                imageView2 = this.a.c;
                imageView2.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_2);
                imageView3 = this.a.d;
                imageView3.setImageResource(com.baidu.tieba.a.g.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.a;
        i3 = goOnAnimView2.e;
        goOnAnimView2.e = i3 + 1;
        handler = this.a.f;
        handler.removeMessages(0);
        handler2 = this.a.f;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
