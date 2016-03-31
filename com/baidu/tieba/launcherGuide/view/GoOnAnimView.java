package com.baidu.tieba.launcherGuide.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView cDH;
    private ImageView cDI;
    private ImageView cDJ;
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(t.h.go_on_anim, (ViewGroup) null, false);
        this.cDH = (ImageView) linearLayout.findViewById(t.g.tip_go_on_1);
        this.cDI = (ImageView) linearLayout.findViewById(t.g.tip_go_on_2);
        this.cDJ = (ImageView) linearLayout.findViewById(t.g.tip_go_on_3);
        this.cDH.setImageResource(t.f.pic_startpage1_next_3);
        this.cDI.setImageResource(t.f.pic_startpage1_next_2);
        this.cDJ.setImageResource(t.f.pic_startpage1_next_1);
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
        if (this.cDH != null) {
            this.cDH.setImageDrawable(null);
        }
        if (this.cDI != null) {
            this.cDI.setImageDrawable(null);
        }
        if (this.cDJ != null) {
            this.cDJ.setImageDrawable(null);
        }
    }
}
