package com.baidu.tieba.launcherGuide.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView bwV;
    private ImageView bwW;
    private ImageView bwX;
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
        LinearLayout linearLayout = (LinearLayout) b.hH().a(context, w.go_on_anim, null, false);
        this.bwV = (ImageView) linearLayout.findViewById(v.tip_go_on_1);
        this.bwW = (ImageView) linearLayout.findViewById(v.tip_go_on_2);
        this.bwX = (ImageView) linearLayout.findViewById(v.tip_go_on_3);
        this.bwV.setImageResource(u.pic_startpage1_next_1);
        this.bwW.setImageResource(u.pic_startpage1_next_2);
        this.bwX.setImageResource(u.pic_startpage1_next_3);
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
        if (this.bwV != null) {
            this.bwV.setImageDrawable(null);
        }
        if (this.bwW != null) {
            this.bwW.setImageDrawable(null);
        }
        if (this.bwX != null) {
            this.bwX.setImageDrawable(null);
        }
    }
}
