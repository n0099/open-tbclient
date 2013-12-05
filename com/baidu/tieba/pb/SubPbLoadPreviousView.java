package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SubPbLoadPreviousView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f2145a;
    private TextView b;
    private ImageView c;
    private ProgressBar d;

    public SubPbLoadPreviousView(Context context) {
        super(context);
        this.f2145a = context;
        e();
    }

    public SubPbLoadPreviousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2145a = context;
        e();
    }

    private void e() {
        setOrientation(0);
        setClickable(true);
        LayoutInflater.from(this.f2145a).inflate(R.layout.sub_pb_load_previous, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.btn_loadprevious);
        this.c = (ImageView) findViewById(R.id.image_up);
        this.d = (ProgressBar) findViewById(R.id.progress);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
        this.c.setOnClickListener(onClickListener);
    }

    public void a() {
        this.b.setText(R.string.loading);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
    }

    public void b() {
        this.b.setText(R.string.view_previous_floor);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    public void a(int i) {
        if (i == 1) {
        }
    }

    public void c() {
        setVisibility(8);
    }

    public void d() {
        setVisibility(0);
    }
}
