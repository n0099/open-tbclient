package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView aNq;
    private ImageView aNr;
    private ImageView aNs;
    private Handler mHandler;
    private int tag;

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new j(this);
        init(context);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.mHandler = new j(this);
        init(context);
    }

    private void init(Context context) {
        LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().a(context, x.go_on_anim, null, false);
        this.aNq = (ImageView) linearLayout.findViewById(w.tip_go_on_1);
        this.aNr = (ImageView) linearLayout.findViewById(w.tip_go_on_2);
        this.aNs = (ImageView) linearLayout.findViewById(w.tip_go_on_3);
        this.aNq.setImageResource(v.pic_startpage1_next_1);
        this.aNr.setImageResource(v.pic_startpage1_next_2);
        this.aNs.setImageResource(v.pic_startpage1_next_3);
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
        if (this.aNq != null) {
            this.aNq.setImageDrawable(null);
        }
        if (this.aNr != null) {
            this.aNr.setImageDrawable(null);
        }
        if (this.aNs != null) {
            this.aNs.setImageDrawable(null);
        }
    }
}
