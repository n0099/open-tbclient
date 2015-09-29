package com.baidu.tieba.launcherGuide.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ GoOnAnimView bTl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoOnAnimView goOnAnimView) {
        this.bTl = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.bTl;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.bTl.tag;
        switch (i2) {
            case 0:
                imageView10 = this.bTl.bRE;
                imageView10.setImageResource(i.e.pic_startpage1_next_3);
                imageView11 = this.bTl.bRF;
                imageView11.setImageResource(i.e.pic_startpage1_next_2);
                imageView12 = this.bTl.bRG;
                imageView12.setImageResource(i.e.pic_startpage1_next_1);
                break;
            case 1:
                imageView7 = this.bTl.bRE;
                imageView7.setImageResource(i.e.pic_startpage1_next_2);
                imageView8 = this.bTl.bRF;
                imageView8.setImageResource(i.e.pic_startpage1_next_1);
                imageView9 = this.bTl.bRG;
                imageView9.setImageResource(i.e.pic_startpage1_next_3);
                break;
            case 2:
                imageView4 = this.bTl.bRE;
                imageView4.setImageResource(i.e.pic_startpage1_next_1);
                imageView5 = this.bTl.bRF;
                imageView5.setImageResource(i.e.pic_startpage1_next_3);
                imageView6 = this.bTl.bRG;
                imageView6.setImageResource(i.e.pic_startpage1_next_2);
                break;
            case 3:
                imageView = this.bTl.bRE;
                imageView.setImageResource(i.e.pic_startpage1_next_2);
                imageView2 = this.bTl.bRF;
                imageView2.setImageResource(i.e.pic_startpage1_next_2);
                imageView3 = this.bTl.bRG;
                imageView3.setImageResource(i.e.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.bTl;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.bTl.mHandler;
        handler.removeMessages(0);
        handler2 = this.bTl.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
