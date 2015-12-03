package com.baidu.tieba.launcherGuide.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView cix;
    private ImageView ciy;
    private ImageView ciz;
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(n.g.go_on_anim, (ViewGroup) null, false);
        this.cix = (ImageView) linearLayout.findViewById(n.f.tip_go_on_1);
        this.ciy = (ImageView) linearLayout.findViewById(n.f.tip_go_on_2);
        this.ciz = (ImageView) linearLayout.findViewById(n.f.tip_go_on_3);
        this.cix.setImageResource(n.e.pic_startpage1_next_3);
        this.ciy.setImageResource(n.e.pic_startpage1_next_2);
        this.ciz.setImageResource(n.e.pic_startpage1_next_1);
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
        if (this.cix != null) {
            this.cix.setImageDrawable(null);
        }
        if (this.ciy != null) {
            this.ciy.setImageDrawable(null);
        }
        if (this.ciz != null) {
            this.ciz.setImageDrawable(null);
        }
    }
}
