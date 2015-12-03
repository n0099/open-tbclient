package com.baidu.tieba.launcherGuide.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ GoOnAnimView ckf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoOnAnimView goOnAnimView) {
        this.ckf = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.ckf;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.ckf.tag;
        switch (i2) {
            case 0:
                imageView10 = this.ckf.cix;
                imageView10.setImageResource(n.e.pic_startpage1_next_3);
                imageView11 = this.ckf.ciy;
                imageView11.setImageResource(n.e.pic_startpage1_next_2);
                imageView12 = this.ckf.ciz;
                imageView12.setImageResource(n.e.pic_startpage1_next_1);
                break;
            case 1:
                imageView7 = this.ckf.cix;
                imageView7.setImageResource(n.e.pic_startpage1_next_2);
                imageView8 = this.ckf.ciy;
                imageView8.setImageResource(n.e.pic_startpage1_next_1);
                imageView9 = this.ckf.ciz;
                imageView9.setImageResource(n.e.pic_startpage1_next_3);
                break;
            case 2:
                imageView4 = this.ckf.cix;
                imageView4.setImageResource(n.e.pic_startpage1_next_1);
                imageView5 = this.ckf.ciy;
                imageView5.setImageResource(n.e.pic_startpage1_next_3);
                imageView6 = this.ckf.ciz;
                imageView6.setImageResource(n.e.pic_startpage1_next_2);
                break;
            case 3:
                imageView = this.ckf.cix;
                imageView.setImageResource(n.e.pic_startpage1_next_2);
                imageView2 = this.ckf.ciy;
                imageView2.setImageResource(n.e.pic_startpage1_next_2);
                imageView3 = this.ckf.ciz;
                imageView3.setImageResource(n.e.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.ckf;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.ckf.mHandler;
        handler.removeMessages(0);
        handler2 = this.ckf.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
