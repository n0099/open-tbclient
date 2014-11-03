package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView aLx;
    private ImageView aLy;
    private ImageView aLz;
    private Handler mHandler;
    private int tag;

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new r(this);
        init(context);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.mHandler = new r(this);
        init(context);
    }

    private void init(Context context) {
        LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.go_on_anim, null, false);
        this.aLx = (ImageView) linearLayout.findViewById(com.baidu.tieba.v.tip_go_on_1);
        this.aLy = (ImageView) linearLayout.findViewById(com.baidu.tieba.v.tip_go_on_2);
        this.aLz = (ImageView) linearLayout.findViewById(com.baidu.tieba.v.tip_go_on_3);
        this.aLx.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
        this.aLy.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
        this.aLz.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
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
        if (this.aLx != null) {
            this.aLx.setImageDrawable(null);
        }
        if (this.aLy != null) {
            this.aLy.setImageDrawable(null);
        }
        if (this.aLz != null) {
            this.aLz.setImageDrawable(null);
        }
    }
}
