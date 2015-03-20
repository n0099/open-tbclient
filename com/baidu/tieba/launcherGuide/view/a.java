package com.baidu.tieba.launcherGuide.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ GoOnAnimView byk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoOnAnimView goOnAnimView) {
        this.byk = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.byk;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.byk.tag;
        switch (i2) {
            case 0:
                imageView10 = this.byk.bwF;
                imageView10.setImageResource(u.pic_startpage1_next_1);
                imageView11 = this.byk.bwG;
                imageView11.setImageResource(u.pic_startpage1_next_2);
                imageView12 = this.byk.bwH;
                imageView12.setImageResource(u.pic_startpage1_next_3);
                break;
            case 1:
                imageView7 = this.byk.bwF;
                imageView7.setImageResource(u.pic_startpage1_next_3);
                imageView8 = this.byk.bwG;
                imageView8.setImageResource(u.pic_startpage1_next_1);
                imageView9 = this.byk.bwH;
                imageView9.setImageResource(u.pic_startpage1_next_2);
                break;
            case 2:
                imageView4 = this.byk.bwF;
                imageView4.setImageResource(u.pic_startpage1_next_2);
                imageView5 = this.byk.bwG;
                imageView5.setImageResource(u.pic_startpage1_next_3);
                imageView6 = this.byk.bwH;
                imageView6.setImageResource(u.pic_startpage1_next_1);
                break;
            case 3:
                imageView = this.byk.bwF;
                imageView.setImageResource(u.pic_startpage1_next_2);
                imageView2 = this.byk.bwG;
                imageView2.setImageResource(u.pic_startpage1_next_2);
                imageView3 = this.byk.bwH;
                imageView3.setImageResource(u.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.byk;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.byk.mHandler;
        handler.removeMessages(0);
        handler2 = this.byk.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
