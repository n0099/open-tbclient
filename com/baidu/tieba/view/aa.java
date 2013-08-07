package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class aa extends LinearLayout implements com.baidu.adp.widget.ScrollView.c {

    /* renamed from: a  reason: collision with root package name */
    private Animation f1805a;
    private Animation b;
    private ProgressBar c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private boolean g;

    public aa(Context context) {
        this(context, null);
        this.f1805a = AnimationUtils.loadAnimation(getContext(), R.anim.arrow_down_to_up);
        this.b = AnimationUtils.loadAnimation(getContext(), R.anim.arrow_up_to_down);
        this.f1805a.setFillAfter(true);
        this.b.setFillAfter(true);
        LayoutInflater.from(context).inflate(R.layout.image_frs_pullview, this);
        this.c = (ProgressBar) findViewById(R.id.head_layout_left_progressbar);
        this.d = (ImageView) findViewById(R.id.head_layout_left_arrow);
        this.e = (TextView) findViewById(R.id.head_layout_title);
        this.f = (TextView) findViewById(R.id.head_layout_refresh_time);
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void a() {
        if (this.g) {
            this.d.startAnimation(this.b);
            this.g = false;
        }
        this.e.setText(getResources().getString(R.string.pulldown_refresh));
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void b() {
        this.d.startAnimation(this.f1805a);
        this.g = true;
        this.e.setText(getResources().getString(R.string.pulldown_loosen));
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void c() {
        this.g = false;
        this.c.setVisibility(0);
        this.e.setText(getResources().getString(R.string.pulldown_loading));
        this.d.clearAnimation();
        this.d.setVisibility(4);
    }

    @Override // com.baidu.adp.widget.ScrollView.c
    public void d() {
        this.g = false;
        this.d.setVisibility(0);
        this.c.setVisibility(8);
        this.e.setText(getResources().getString(R.string.pulldown_refresh));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        this.f.setVisibility(0);
        this.f.setText(String.valueOf(getResources().getString(R.string.pulldown_lasttime)) + simpleDateFormat.format(date));
    }

    public LinearLayout getRealView() {
        return this;
    }

    public void a(int i) {
        if (i == 1) {
            this.e.setTextColor(-8682095);
            this.f.setTextColor(-8682095);
            return;
        }
        this.e.setTextColor(-14277082);
        this.f.setTextColor(-14277082);
    }
}
