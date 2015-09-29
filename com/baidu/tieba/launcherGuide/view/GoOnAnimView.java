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
    private ImageView bRE;
    private ImageView bRF;
    private ImageView bRG;
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
        this.bRE = (ImageView) linearLayout.findViewById(i.f.tip_go_on_1);
        this.bRF = (ImageView) linearLayout.findViewById(i.f.tip_go_on_2);
        this.bRG = (ImageView) linearLayout.findViewById(i.f.tip_go_on_3);
        this.bRE.setImageResource(i.e.pic_startpage1_next_3);
        this.bRF.setImageResource(i.e.pic_startpage1_next_2);
        this.bRG.setImageResource(i.e.pic_startpage1_next_1);
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
        if (this.bRE != null) {
            this.bRE.setImageDrawable(null);
        }
        if (this.bRF != null) {
            this.bRF.setImageDrawable(null);
        }
        if (this.bRG != null) {
            this.bRG.setImageDrawable(null);
        }
    }
}
