package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ GoOnAnimView bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GoOnAnimView goOnAnimView) {
        this.bRq = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.bRq;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.bRq.tag;
        switch (i2) {
            case 0:
                imageView10 = this.bRq.aLj;
                imageView10.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
                imageView11 = this.bRq.aLk;
                imageView11.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView12 = this.bRq.aLl;
                imageView12.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
                break;
            case 1:
                imageView7 = this.bRq.aLj;
                imageView7.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
                imageView8 = this.bRq.aLk;
                imageView8.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
                imageView9 = this.bRq.aLl;
                imageView9.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                break;
            case 2:
                imageView4 = this.bRq.aLj;
                imageView4.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView5 = this.bRq.aLk;
                imageView5.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
                imageView6 = this.bRq.aLl;
                imageView6.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
                break;
            case 3:
                imageView = this.bRq.aLj;
                imageView.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView2 = this.bRq.aLk;
                imageView2.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView3 = this.bRq.aLl;
                imageView3.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.bRq;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.bRq.mHandler;
        handler.removeMessages(0);
        handler2 = this.bRq.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
