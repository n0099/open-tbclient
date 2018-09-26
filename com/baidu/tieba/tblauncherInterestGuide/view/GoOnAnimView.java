package com.baidu.tieba.tblauncherInterestGuide.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView hbW;
    private ImageView hbX;
    private ImageView hbY;
    private Handler mHandler;
    private int tag;

    static /* synthetic */ int e(GoOnAnimView goOnAnimView) {
        int i = goOnAnimView.tag;
        goOnAnimView.tag = i + 1;
        return i;
    }

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                GoOnAnimView.this.tag %= 4;
                switch (GoOnAnimView.this.tag) {
                    case 0:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_3);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_1);
                        break;
                    case 1:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_1);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_3);
                        break;
                    case 2:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_1);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_3);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_2);
                        break;
                    case 3:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_2);
                        break;
                }
                GoOnAnimView.e(GoOnAnimView.this);
                GoOnAnimView.this.mHandler.removeMessages(0);
                GoOnAnimView.this.mHandler.sendEmptyMessageDelayed(0, 300L);
            }
        };
        init(context);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                GoOnAnimView.this.tag %= 4;
                switch (GoOnAnimView.this.tag) {
                    case 0:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_3);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_1);
                        break;
                    case 1:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_1);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_3);
                        break;
                    case 2:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_1);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_3);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_2);
                        break;
                    case 3:
                        GoOnAnimView.this.hbW.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbX.setImageResource(e.f.pic_startpage1_next_2);
                        GoOnAnimView.this.hbY.setImageResource(e.f.pic_startpage1_next_2);
                        break;
                }
                GoOnAnimView.e(GoOnAnimView.this);
                GoOnAnimView.this.mHandler.removeMessages(0);
                GoOnAnimView.this.mHandler.sendEmptyMessageDelayed(0, 300L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(e.h.go_on_anim, (ViewGroup) null, false);
        this.hbW = (ImageView) linearLayout.findViewById(e.g.tip_go_on_1);
        this.hbX = (ImageView) linearLayout.findViewById(e.g.tip_go_on_2);
        this.hbY = (ImageView) linearLayout.findViewById(e.g.tip_go_on_3);
        this.hbW.setImageResource(e.f.pic_startpage1_next_3);
        this.hbX.setImageResource(e.f.pic_startpage1_next_2);
        this.hbY.setImageResource(e.f.pic_startpage1_next_1);
        addView(linearLayout);
    }

    public void onStart() {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessage(0);
    }

    public void onStop() {
        this.mHandler.removeMessages(0);
    }

    public void onDestroy() {
        this.mHandler.removeMessages(0);
        if (this.hbW != null) {
            this.hbW.setImageDrawable(null);
        }
        if (this.hbX != null) {
            this.hbX.setImageDrawable(null);
        }
        if (this.hbY != null) {
            this.hbY.setImageDrawable(null);
        }
    }
}
