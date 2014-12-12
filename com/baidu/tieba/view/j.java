package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
class j extends Handler {
    final /* synthetic */ GoOnAnimView cdH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GoOnAnimView goOnAnimView) {
        this.cdH = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.cdH;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.cdH.tag;
        switch (i2) {
            case 0:
                imageView10 = this.cdH.aNq;
                imageView10.setImageResource(v.pic_startpage1_next_1);
                imageView11 = this.cdH.aNr;
                imageView11.setImageResource(v.pic_startpage1_next_2);
                imageView12 = this.cdH.aNs;
                imageView12.setImageResource(v.pic_startpage1_next_3);
                break;
            case 1:
                imageView7 = this.cdH.aNq;
                imageView7.setImageResource(v.pic_startpage1_next_3);
                imageView8 = this.cdH.aNr;
                imageView8.setImageResource(v.pic_startpage1_next_1);
                imageView9 = this.cdH.aNs;
                imageView9.setImageResource(v.pic_startpage1_next_2);
                break;
            case 2:
                imageView4 = this.cdH.aNq;
                imageView4.setImageResource(v.pic_startpage1_next_2);
                imageView5 = this.cdH.aNr;
                imageView5.setImageResource(v.pic_startpage1_next_3);
                imageView6 = this.cdH.aNs;
                imageView6.setImageResource(v.pic_startpage1_next_1);
                break;
            case 3:
                imageView = this.cdH.aNq;
                imageView.setImageResource(v.pic_startpage1_next_2);
                imageView2 = this.cdH.aNr;
                imageView2.setImageResource(v.pic_startpage1_next_2);
                imageView3 = this.cdH.aNs;
                imageView3.setImageResource(v.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.cdH;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.cdH.mHandler;
        handler.removeMessages(0);
        handler2 = this.cdH.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
