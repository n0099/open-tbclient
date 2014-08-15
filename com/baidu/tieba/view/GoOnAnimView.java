package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class GoOnAnimView extends LinearLayout {
    private ImageView a;
    private ImageView b;
    private ImageView c;
    private int d;
    private Handler e;

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new r(this);
        a(context);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.e = new r(this);
        a(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.go_on_anim, (ViewGroup) null, false);
        this.a = (ImageView) linearLayout.findViewById(com.baidu.tieba.u.tip_go_on_1);
        this.b = (ImageView) linearLayout.findViewById(com.baidu.tieba.u.tip_go_on_2);
        this.c = (ImageView) linearLayout.findViewById(com.baidu.tieba.u.tip_go_on_3);
        this.a.setImageResource(com.baidu.tieba.t.pic_startpage1_next_1);
        this.b.setImageResource(com.baidu.tieba.t.pic_startpage1_next_2);
        this.c.setImageResource(com.baidu.tieba.t.pic_startpage1_next_3);
        addView(linearLayout);
    }

    public void a() {
        this.e.removeMessages(0);
        this.e.sendEmptyMessage(0);
    }

    public void b() {
        this.e.removeMessages(0);
    }

    public void c() {
        this.e.removeMessages(0);
        if (this.a != null) {
            this.a.setImageDrawable(null);
        }
        if (this.b != null) {
            this.b.setImageDrawable(null);
        }
        if (this.c != null) {
            this.c.setImageDrawable(null);
        }
    }
}
