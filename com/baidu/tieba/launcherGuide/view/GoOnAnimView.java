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
    private ImageView bwF;
    private ImageView bwG;
    private ImageView bwH;
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
        this.bwF = (ImageView) linearLayout.findViewById(v.tip_go_on_1);
        this.bwG = (ImageView) linearLayout.findViewById(v.tip_go_on_2);
        this.bwH = (ImageView) linearLayout.findViewById(v.tip_go_on_3);
        this.bwF.setImageResource(u.pic_startpage1_next_1);
        this.bwG.setImageResource(u.pic_startpage1_next_2);
        this.bwH.setImageResource(u.pic_startpage1_next_3);
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
        if (this.bwF != null) {
            this.bwF.setImageDrawable(null);
        }
        if (this.bwG != null) {
            this.bwG.setImageDrawable(null);
        }
        if (this.bwH != null) {
            this.bwH.setImageDrawable(null);
        }
    }
}
