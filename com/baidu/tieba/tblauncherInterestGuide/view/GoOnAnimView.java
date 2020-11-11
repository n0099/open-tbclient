package com.baidu.tieba.tblauncherInterestGuide.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class GoOnAnimView extends LinearLayout {
    private Handler mHandler;
    private ImageView ner;
    private ImageView nes;
    private ImageView neu;
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
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_1);
                        break;
                    case 1:
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_3);
                        break;
                    case 2:
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_2);
                        break;
                    case 3:
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_2);
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
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_1);
                        break;
                    case 1:
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_3);
                        break;
                    case 2:
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_2);
                        break;
                    case 3:
                        GoOnAnimView.this.ner.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.nes.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.neu.setImageResource(R.drawable.pic_startpage1_next_2);
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.go_on_anim, (ViewGroup) null, false);
        this.ner = (ImageView) linearLayout.findViewById(R.id.tip_go_on_1);
        this.nes = (ImageView) linearLayout.findViewById(R.id.tip_go_on_2);
        this.neu = (ImageView) linearLayout.findViewById(R.id.tip_go_on_3);
        this.ner.setImageResource(R.drawable.pic_startpage1_next_3);
        this.nes.setImageResource(R.drawable.pic_startpage1_next_2);
        this.neu.setImageResource(R.drawable.pic_startpage1_next_1);
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
        if (this.ner != null) {
            this.ner.setImageDrawable(null);
        }
        if (this.nes != null) {
            this.nes.setImageDrawable(null);
        }
        if (this.neu != null) {
            this.neu.setImageDrawable(null);
        }
    }
}
