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
    private Context a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private int e;
    private Handler f;

    public GoOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new s(this);
        a(context);
    }

    public GoOnAnimView(Context context) {
        super(context);
        this.f = new s(this);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.go_on_anim, (ViewGroup) null, false);
        this.b = (ImageView) linearLayout.findViewById(com.baidu.tieba.v.tip_go_on_1);
        this.c = (ImageView) linearLayout.findViewById(com.baidu.tieba.v.tip_go_on_2);
        this.d = (ImageView) linearLayout.findViewById(com.baidu.tieba.v.tip_go_on_3);
        this.b.setImageResource(com.baidu.tieba.u.pic_startpage1_next_1);
        this.c.setImageResource(com.baidu.tieba.u.pic_startpage1_next_2);
        this.d.setImageResource(com.baidu.tieba.u.pic_startpage1_next_3);
        addView(linearLayout);
    }

    public void a() {
        this.f.removeMessages(0);
        this.f.sendEmptyMessage(0);
    }

    public void b() {
        this.f.removeMessages(0);
    }

    public void c() {
        this.f.removeMessages(0);
        if (this.b != null) {
            this.b.setImageBitmap(null);
        }
        if (this.c != null) {
            this.c.setImageBitmap(null);
        }
        if (this.d != null) {
            this.d.setImageBitmap(null);
        }
    }
}
