package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class SubPbLoadPreviousView extends LinearLayout {
    private Context a;
    private TextView b;
    private ProgressBar c;

    public SubPbLoadPreviousView(Context context) {
        super(context);
        this.a = context;
        e();
    }

    public SubPbLoadPreviousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        e();
    }

    private void e() {
        setOrientation(0);
        setClickable(true);
        LayoutInflater.from(this.a).inflate(v.sub_pb_load_previous, (ViewGroup) this, true);
        this.b = (TextView) findViewById(u.btn_loadprevious);
        this.c = (ProgressBar) findViewById(u.progress);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void a() {
        this.b.setText(x.loading);
        this.c.setVisibility(0);
    }

    public void b() {
        this.b.setText(x.view_previous_floor);
        this.c.setVisibility(8);
    }

    public void a(int i) {
    }

    public void c() {
        setVisibility(8);
    }

    public void d() {
        setVisibility(0);
    }
}
