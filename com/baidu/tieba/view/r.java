package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
/* loaded from: classes.dex */
class r extends Handler {
    final /* synthetic */ GoOnAnimView bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GoOnAnimView goOnAnimView) {
        this.bRF = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.bRF;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.bRF.tag;
        switch (i2) {
            case 0:
                imageView10 = this.bRF.aLx;
                imageView10.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
                imageView11 = this.bRF.aLy;
                imageView11.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView12 = this.bRF.aLz;
                imageView12.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
                break;
            case 1:
                imageView7 = this.bRF.aLx;
                imageView7.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
                imageView8 = this.bRF.aLy;
                imageView8.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
                imageView9 = this.bRF.aLz;
                imageView9.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                break;
            case 2:
                imageView4 = this.bRF.aLx;
                imageView4.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView5 = this.bRF.aLy;
                imageView5.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
                imageView6 = this.bRF.aLz;
                imageView6.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
                break;
            case 3:
                imageView = this.bRF.aLx;
                imageView.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView2 = this.bRF.aLy;
                imageView2.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                imageView3 = this.bRF.aLz;
                imageView3.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.bRF;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.bRF.mHandler;
        handler.removeMessages(0);
        handler2 = this.bRF.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
