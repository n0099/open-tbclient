package com.baidu.tieba.square;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CarouselRecommendView extends FrameLayout {
    private static int l = 5000;
    public View.OnTouchListener a;
    private Context b;
    private ViewPager c;
    private IndicatorView d;
    private CarouselRecommendPagerAdapter e;
    private int f;
    private int g;
    private float h;
    private final int i;
    private final int j;
    private final int k;
    private ArrayList<au> m;
    private Handler n;

    public CarouselRecommendView(Context context) {
        this(context, null);
    }

    public CarouselRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0.3043478f;
        this.m = new ArrayList<>();
        this.n = new v(this);
        this.a = new w(this);
        this.b = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.carousel_topics_recommend, (ViewGroup) this, true);
        this.c = (ViewPager) findViewById(R.id.carousel_pager);
        this.d = (IndicatorView) findViewById(R.id.carousel_indicator);
        this.c.setOnTouchListener(this.a);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.square_caroucel_paddingTop);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.square_caroucel_paddingBottom);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.square_page_padding);
        this.f = com.baidu.adp.lib.g.g.b(context) - (this.k * 2);
        this.g = (int) (0.5f + (this.f * this.h));
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        this.c.setLayoutParams(layoutParams);
        this.e = new CarouselRecommendPagerAdapter(this.b);
        setPadding(this.k, this.j, this.k, this.i);
    }

    public Boolean a(ArrayList<au> arrayList) {
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
        this.c.setOnPageChangeListener(new y(this, null));
        this.c.a(size > 1 ? 1 : 0, false);
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

    public void a(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void a() {
        this.n.removeMessages(0);
        this.n.sendEmptyMessageDelayed(0, l);
    }

    public void b() {
        this.n.removeMessages(0);
    }

    public CarouselRecommendPagerAdapter getPagerAdapter() {
        return this.e;
    }

    /* loaded from: classes.dex */
    public class CarouselRecommendPagerAdapter extends android.support.v4.view.ae implements com.baidu.tbadk.imageManager.c, com.baidu.tieba.view.bb {
        private Context f;
        private com.baidu.tieba.util.i g;
        private int h;
        private int i;
        private LayoutInflater k;
        private View l;
        private ArrayList<au> c = null;
        private int d = 0;
        private ArrayList<View> e = new ArrayList<>();
        public ArrayList<HeadImageView> a = new ArrayList<>();
        private float j = 0.46875f;

        public CarouselRecommendPagerAdapter(Context context) {
            this.f = null;
            this.g = null;
            this.h = 0;
            this.i = 0;
            this.k = null;
            this.f = context;
            this.k = LayoutInflater.from(context);
            this.g = new com.baidu.tieba.util.i(context);
            this.h = com.baidu.adp.lib.g.g.b(context);
            this.i = (int) (0.5f + (this.h * this.j));
            this.g.a(this.h, this.i);
        }

        private void a(HeadImageView headImageView, au auVar, int i) {
            headImageView.setTag(auVar.a());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.h, this.i));
            headImageView.setOnClickListener(new x(this, auVar, i));
            this.a.add(headImageView);
        }

        public void a(ArrayList<au> arrayList) {
            a();
            if (arrayList != null && arrayList.size() != 0) {
                this.d = arrayList.size();
                this.c = arrayList;
                int i = 0;
                while (i < this.d) {
                    HeadImageView headImageView = (HeadImageView) this.k.inflate(R.layout.carousel_topics_recommend_item, (ViewGroup) null);
                    a(headImageView, arrayList.get(i), i > 0 ? i - 1 : 0);
                    this.e.add(headImageView);
                    i++;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.support.v4.view.ae
        public int getCount() {
            if (this.e == null) {
                return 0;
            }
            return this.e.size();
        }

        @Override // android.support.v4.view.ae
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.e.get(i);
            view.invalidate();
            viewGroup.addView(view);
            return view;
        }

        public void a(int i) {
            if (this.a != null && this.a.size() > 0) {
                Iterator<HeadImageView> it = this.a.iterator();
                while (it.hasNext()) {
                    it.next().invalidate();
                }
            }
        }

        @Override // android.support.v4.view.ae
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.ae
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private void a() {
            this.e.clear();
            this.d = 0;
            this.c = null;
            notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.view.bb
        public void d() {
            if (this.g != null) {
                this.g.d();
            }
        }

        @Override // com.baidu.tieba.view.bb
        public void a(View view, int i, int i2) {
            this.l = view;
            if (this.g != null && this.c != null) {
                this.g.a();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.c.size()) {
                        String a = this.c.get(i4).a();
                        if (this.l != null) {
                            ((HeadImageView) this.l.findViewWithTag(a)).setDefaultScaleType(ImageView.ScaleType.CENTER);
                        }
                        this.g.b(this.c.get(i4).a(), this);
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.imageManager.c
        public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
            HeadImageView headImageView;
            if (this.l != null && (headImageView = (HeadImageView) this.l.findViewWithTag(str)) != null) {
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.invalidate();
            }
        }
    }
}
