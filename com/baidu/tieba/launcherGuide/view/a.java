package com.baidu.tieba.launcherGuide.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ GoOnAnimView cFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoOnAnimView goOnAnimView) {
        this.cFr = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.cFr;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.cFr.tag;
        switch (i2) {
            case 0:
                imageView10 = this.cFr.cDH;
                imageView10.setImageResource(t.f.pic_startpage1_next_3);
                imageView11 = this.cFr.cDI;
                imageView11.setImageResource(t.f.pic_startpage1_next_2);
                imageView12 = this.cFr.cDJ;
                imageView12.setImageResource(t.f.pic_startpage1_next_1);
                break;
            case 1:
                imageView7 = this.cFr.cDH;
                imageView7.setImageResource(t.f.pic_startpage1_next_2);
                imageView8 = this.cFr.cDI;
                imageView8.setImageResource(t.f.pic_startpage1_next_1);
                imageView9 = this.cFr.cDJ;
                imageView9.setImageResource(t.f.pic_startpage1_next_3);
                break;
            case 2:
                imageView4 = this.cFr.cDH;
                imageView4.setImageResource(t.f.pic_startpage1_next_1);
                imageView5 = this.cFr.cDI;
                imageView5.setImageResource(t.f.pic_startpage1_next_3);
                imageView6 = this.cFr.cDJ;
                imageView6.setImageResource(t.f.pic_startpage1_next_2);
                break;
            case 3:
                imageView = this.cFr.cDH;
                imageView.setImageResource(t.f.pic_startpage1_next_2);
                imageView2 = this.cFr.cDI;
                imageView2.setImageResource(t.f.pic_startpage1_next_2);
                imageView3 = this.cFr.cDJ;
                imageView3.setImageResource(t.f.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.cFr;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.cFr.mHandler;
        handler.removeMessages(0);
        handler2 = this.cFr.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
