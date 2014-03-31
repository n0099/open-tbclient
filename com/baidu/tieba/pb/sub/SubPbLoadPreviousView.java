package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class SubPbLoadPreviousView extends LinearLayout {
    private Context a;
    private TextView b;
    private ImageView c;
    private ProgressBar d;

    public SubPbLoadPreviousView(Context context) {
        super(context);
        this.a = context;
        f();
    }

    public SubPbLoadPreviousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        f();
    }

    private void f() {
        setOrientation(0);
        setClickable(true);
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.sub_pb_load_previous, (ViewGroup) this, true);
        this.b = (TextView) findViewById(com.baidu.tieba.a.h.btn_loadprevious);
        this.c = (ImageView) findViewById(com.baidu.tieba.a.h.image_up);
        this.d = (ProgressBar) findViewById(com.baidu.tieba.a.h.progress);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
    }

    public final void a() {
        this.b.setText(com.baidu.tieba.a.k.loading);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public final void b() {
        this.b.setText(com.baidu.tieba.a.k.view_previous_floor);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    public static void c() {
    }

    public final void d() {
        setVisibility(8);
    }

    public final void e() {
        setVisibility(0);
    }
}
