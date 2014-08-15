package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ GoOnAnimView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GoOnAnimView goOnAnimView) {
        this.a = goOnAnimView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
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
        i = goOnAnimView.d;
        goOnAnimView.d = i % 4;
        i2 = this.a.d;
        switch (i2) {
            case 0:
                imageView10 = this.a.a;
                imageView10.setImageResource(com.baidu.tieba.t.pic_startpage1_next_1);
                imageView11 = this.a.b;
                imageView11.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
                imageView12 = this.a.c;
                imageView12.setImageResource(com.baidu.tieba.t.pic_startpage1_next_3);
                break;
            case 1:
                imageView7 = this.a.a;
                imageView7.setImageResource(com.baidu.tieba.t.pic_startpage1_next_3);
                imageView8 = this.a.b;
                imageView8.setImageResource(com.baidu.tieba.t.pic_startpage1_next_1);
                imageView9 = this.a.c;
                imageView9.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
                break;
            case 2:
                imageView4 = this.a.a;
                imageView4.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
                imageView5 = this.a.b;
                imageView5.setImageResource(com.baidu.tieba.t.pic_startpage1_next_3);
                imageView6 = this.a.c;
                imageView6.setImageResource(com.baidu.tieba.t.pic_startpage1_next_1);
                break;
            case 3:
                imageView = this.a.a;
                imageView.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
                imageView2 = this.a.b;
                imageView2.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
                imageView3 = this.a.c;
                imageView3.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.a;
        i3 = goOnAnimView2.d;
        goOnAnimView2.d = i3 + 1;
        handler = this.a.e;
        handler.removeMessages(0);
        handler2 = this.a.e;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
