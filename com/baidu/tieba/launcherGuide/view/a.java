package com.baidu.tieba.launcherGuide.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a extends Handler {
    final /* synthetic */ GoOnAnimView bTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GoOnAnimView goOnAnimView) {
        this.bTw = goOnAnimView;
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
        GoOnAnimView goOnAnimView = this.bTw;
        i = goOnAnimView.tag;
        goOnAnimView.tag = i % 4;
        i2 = this.bTw.tag;
        switch (i2) {
            case 0:
                imageView10 = this.bTw.bRP;
                imageView10.setImageResource(i.e.pic_startpage1_next_3);
                imageView11 = this.bTw.bRQ;
                imageView11.setImageResource(i.e.pic_startpage1_next_2);
                imageView12 = this.bTw.bRR;
                imageView12.setImageResource(i.e.pic_startpage1_next_1);
                break;
            case 1:
                imageView7 = this.bTw.bRP;
                imageView7.setImageResource(i.e.pic_startpage1_next_2);
                imageView8 = this.bTw.bRQ;
                imageView8.setImageResource(i.e.pic_startpage1_next_1);
                imageView9 = this.bTw.bRR;
                imageView9.setImageResource(i.e.pic_startpage1_next_3);
                break;
            case 2:
                imageView4 = this.bTw.bRP;
                imageView4.setImageResource(i.e.pic_startpage1_next_1);
                imageView5 = this.bTw.bRQ;
                imageView5.setImageResource(i.e.pic_startpage1_next_3);
                imageView6 = this.bTw.bRR;
                imageView6.setImageResource(i.e.pic_startpage1_next_2);
                break;
            case 3:
                imageView = this.bTw.bRP;
                imageView.setImageResource(i.e.pic_startpage1_next_2);
                imageView2 = this.bTw.bRQ;
                imageView2.setImageResource(i.e.pic_startpage1_next_2);
                imageView3 = this.bTw.bRR;
                imageView3.setImageResource(i.e.pic_startpage1_next_2);
                break;
        }
        GoOnAnimView goOnAnimView2 = this.bTw;
        i3 = goOnAnimView2.tag;
        goOnAnimView2.tag = i3 + 1;
        handler = this.bTw.mHandler;
        handler.removeMessages(0);
        handler2 = this.bTw.mHandler;
        handler2.sendEmptyMessageDelayed(0, 300L);
    }
}
