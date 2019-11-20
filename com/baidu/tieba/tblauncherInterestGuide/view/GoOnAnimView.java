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
/* loaded from: classes4.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView joN;
    private ImageView joO;
    private ImageView joP;
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
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_1);
                        break;
                    case 1:
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_3);
                        break;
                    case 2:
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_2);
                        break;
                    case 3:
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_2);
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
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_1);
                        break;
                    case 1:
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_3);
                        break;
                    case 2:
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_1);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_3);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_2);
                        break;
                    case 3:
                        GoOnAnimView.this.joN.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joO.setImageResource(R.drawable.pic_startpage1_next_2);
                        GoOnAnimView.this.joP.setImageResource(R.drawable.pic_startpage1_next_2);
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
        this.joN = (ImageView) linearLayout.findViewById(R.id.tip_go_on_1);
        this.joO = (ImageView) linearLayout.findViewById(R.id.tip_go_on_2);
        this.joP = (ImageView) linearLayout.findViewById(R.id.tip_go_on_3);
        this.joN.setImageResource(R.drawable.pic_startpage1_next_3);
        this.joO.setImageResource(R.drawable.pic_startpage1_next_2);
        this.joP.setImageResource(R.drawable.pic_startpage1_next_1);
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
        if (this.joN != null) {
            this.joN.setImageDrawable(null);
        }
        if (this.joO != null) {
            this.joO.setImageDrawable(null);
        }
        if (this.joP != null) {
            this.joP.setImageDrawable(null);
        }
    }
}
