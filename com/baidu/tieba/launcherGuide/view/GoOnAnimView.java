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
    private ImageView bSk;
    private ImageView bSl;
    private ImageView bSm;
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
        this.bSk = (ImageView) linearLayout.findViewById(i.f.tip_go_on_1);
        this.bSl = (ImageView) linearLayout.findViewById(i.f.tip_go_on_2);
        this.bSm = (ImageView) linearLayout.findViewById(i.f.tip_go_on_3);
        this.bSk.setImageResource(i.e.pic_startpage1_next_3);
        this.bSl.setImageResource(i.e.pic_startpage1_next_2);
        this.bSm.setImageResource(i.e.pic_startpage1_next_1);
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
        if (this.bSk != null) {
            this.bSk.setImageDrawable(null);
        }
        if (this.bSl != null) {
            this.bSl.setImageDrawable(null);
        }
        if (this.bSm != null) {
            this.bSm.setImageDrawable(null);
        }
    }
}
