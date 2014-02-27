package com.baidu.tieba.square;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.IndicatorView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class v extends FrameLayout {
    private static int l = 5000;
    public View.OnTouchListener a;
    private Context b;
    private ViewPager c;
    private IndicatorView d;
    private y e;
    private int f;
    private int g;
    private float h;
    private final int i;
    private final int j;
    private final int k;
    private ArrayList<av> m;
    private Handler n;

    public v(Context context) {
        this(context, null);
    }

    private v(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0.3043478f;
        this.m = new ArrayList<>();
        this.n = new w(this);
        this.a = new x(this);
        this.b = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.carousel_topics_recommend, (ViewGroup) this, true);
        this.c = (ViewPager) findViewById(R.id.carousel_pager);
        this.d = (IndicatorView) findViewById(R.id.carousel_indicator);
        this.c.setOnTouchListener(this.a);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.square_caroucel_paddingTop);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.square_caroucel_paddingBottom);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.square_page_padding);
        this.f = BdUtilHelper.b(context) - (this.k * 2);
        this.g = (int) (0.5f + (this.f * this.h));
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        this.c.setLayoutParams(layoutParams);
        this.e = new y(this, this.b);
        setPadding(this.k, this.j, this.k, this.i);
    }

    public final Boolean a(ArrayList<av> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            setVisibility(8);
            return false;
        }
        this.m.clear();
        this.m = arrayList;
        setVisibility(0);
        int size = this.m.size();
        if (size > 1) {
            this.m.add(arrayList.get(0));
            this.m.add(0, arrayList.get(arrayList.size() - 1));
        }
        this.e.a(this.m);
        this.c.setAdapter(this.e);
        this.c.setOnPageChangeListener(new aa(this, (byte) 0));
        this.c.setCurrentItem(size > 1 ? 1 : 0, false);
        this.c.invalidate();
        if (size > 1) {
            this.d.setVisibility(0);
            this.d.setCount(this.m.size() - 2);
            this.d.setPosition(0.0f);
        } else {
            this.d.setVisibility(8);
        }
        a();
        return true;
    }

    public final void a(int i) {
        if (this.e != null) {
            this.e.a();
        }
    }

    public final void a() {
        this.n.removeMessages(0);
        this.n.sendEmptyMessageDelayed(0, l);
    }

    public final void b() {
        this.n.removeMessages(0);
    }

    public final y getPagerAdapter() {
        return this.e;
    }
}
