package com.baidu.tieba.launcherGuide.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView bRP;
    private ImageView bRQ;
    private ImageView bRR;
    private Handler mHandler;
    private int tag;

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new a(this);
        init(context);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.mHandler = new a(this);
        init(context);
    }

    private void init(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(i.g.go_on_anim, (ViewGroup) null, false);
        this.bRP = (ImageView) linearLayout.findViewById(i.f.tip_go_on_1);
        this.bRQ = (ImageView) linearLayout.findViewById(i.f.tip_go_on_2);
        this.bRR = (ImageView) linearLayout.findViewById(i.f.tip_go_on_3);
        this.bRP.setImageResource(i.e.pic_startpage1_next_3);
        this.bRQ.setImageResource(i.e.pic_startpage1_next_2);
        this.bRR.setImageResource(i.e.pic_startpage1_next_1);
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
        if (this.bRP != null) {
            this.bRP.setImageDrawable(null);
        }
        if (this.bRQ != null) {
            this.bRQ.setImageDrawable(null);
        }
        if (this.bRR != null) {
            this.bRR.setImageDrawable(null);
        }
    }
}
