package com.baidu.tieba.square;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends FrameLayout {
    private static int l = 5000;
    public View.OnTouchListener a;
    private Context b;
    private ViewPager c;
    private IndicatorView d;
    private t e;
    private int f;
    private int g;
    private float h;
    private final int i;
    private final int j;
    private final int k;
    private boolean m;
    private View n;
    private FrameLayout o;
    private ArrayList<ap> p;
    private Handler q;

    public q(Context context, boolean z) {
        this(context, null, z);
    }

    public View getViewPagerBottomLine() {
        return this.n;
    }

    public q(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0.3043478f;
        this.m = true;
        this.p = new ArrayList<>();
        this.q = new r(this);
        this.a = new s(this);
        this.b = context;
        this.m = z;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.v.carousel_topics_recommend, (ViewGroup) this, true);
        this.o = (FrameLayout) findViewById(com.baidu.tieba.u.carousel_root_view);
        this.c = (ViewPager) findViewById(com.baidu.tieba.u.carousel_pager);
        if (z) {
            this.n = findViewById(com.baidu.tieba.u.carousel_bottom_line);
            this.d = (IndicatorView) findViewById(com.baidu.tieba.u.carousel_indicator_for_game_center);
        } else {
            this.d = (IndicatorView) findViewById(com.baidu.tieba.u.carousel_indicator);
        }
        this.d.setVisibility(0);
        this.c.setOnTouchListener(this.a);
        this.j = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.square_caroucel_paddingTop);
        this.i = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.square_caroucel_paddingBottom);
        this.k = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.square_page_padding);
        if (this.m) {
            this.f = com.baidu.adp.lib.util.j.b(context);
            this.g = context.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds360);
        } else {
            this.f = com.baidu.adp.lib.util.j.b(context) - (this.k * 2);
            this.g = (int) (0.5f + (this.f * this.h));
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        this.c.setLayoutParams(layoutParams);
        this.e = new t(this, this.b);
        if (!this.m) {
            setPadding(this.k, this.j, this.k, this.i);
        }
    }

    public Boolean a(ArrayList<ap> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            this.o.setVisibility(8);
            return false;
        }
        this.p.clear();
        this.p = arrayList;
        setVisibility(0);
        int size = this.p.size();
        if (size > 1) {
            this.p.add(arrayList.get(0));
            this.p.add(0, arrayList.get(arrayList.size() - 1));
        }
        this.e.a(this.p);
        this.c.setAdapter(this.e);
        this.c.setOnPageChangeListener(new v(this, null));
        this.c.setCurrentItem(size > 1 ? 1 : 0, false);
        this.c.invalidate();
        if (size > 1) {
            this.d.setVisibility(0);
            this.d.setCount(this.p.size() - 2);
            this.d.setPosition(0.0f);
        } else {
            this.d.setVisibility(8);
        }
        a();
        return true;
    }

    public void a(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void a() {
        this.q.removeMessages(0);
        this.q.sendEmptyMessageDelayed(0, l);
    }

    public void b() {
        this.q.removeMessages(0);
    }

    public t getPagerAdapter() {
        return this.e;
    }
}
