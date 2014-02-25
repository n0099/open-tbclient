package com.baidu.tieba.person;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MoreDiscoveryWidget extends FrameLayout {
    private ImageView a;
    private TextView b;
    private ImageView c;
    private ImageView d;
    private Context e;
    private int[] f;

    public MoreDiscoveryWidget(Context context) {
        this(context, null, 0);
    }

    public MoreDiscoveryWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoreDiscoveryWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new int[2];
        this.e = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.more_discovery_widget, (ViewGroup) this, true);
        this.a = (ImageView) findViewById(R.id.widget_icon);
        this.b = (TextView) findViewById(R.id.widget_text);
        this.c = (ImageView) findViewById(R.id.widget_new);
        this.d = (ImageView) findViewById(R.id.widget_remind);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.baidu.tieba.am.moreTabWidget);
        this.b.setText(obtainStyledAttributes.getString(1));
        this.a.setImageDrawable(obtainStyledAttributes.getDrawable(0));
        this.f[0] = obtainStyledAttributes.getResourceId(0, 0);
        this.f[1] = com.baidu.tieba.e.a(getResources(), this.f[0]);
        obtainStyledAttributes.recycle();
    }

    public void a(int i) {
        if (this.e instanceof com.baidu.tieba.f) {
            ((com.baidu.tieba.f) this.e).getLayoutMode().a((View) this);
        } else if (this.e instanceof com.baidu.tieba.k) {
            ((com.baidu.tieba.k) getContext()).a().a((View) this);
        }
        if (1 == i) {
            this.a.setImageResource(this.f[1]);
        } else {
            this.a.setImageResource(this.f[0]);
        }
    }

    public void a() {
        this.c.setVisibility(0);
    }

    public void b() {
        this.c.setVisibility(8);
    }

    public void c() {
        this.d.setVisibility(0);
    }

    public void d() {
        this.d.setVisibility(8);
    }
}
