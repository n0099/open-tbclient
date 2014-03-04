package com.baidu.tieba.square;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.bg;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class y extends PagerAdapter implements com.baidu.tbadk.imageManager.d, bg {
    final /* synthetic */ v b;
    private Context f;
    private com.baidu.tieba.util.i g;
    private int h;
    private int i;
    private LayoutInflater k;
    private View l;
    private ArrayList<av> c = null;
    private int d = 0;
    private ArrayList<View> e = new ArrayList<>();
    public ArrayList<HeadImageView> a = new ArrayList<>();
    private float j = 0.46875f;

    public y(v vVar, Context context) {
        this.b = vVar;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.k = null;
        this.f = context;
        this.k = LayoutInflater.from(context);
        this.g = new com.baidu.tieba.util.i(context);
        this.h = BdUtilHelper.b(context);
        this.i = (int) (0.5f + (this.h * this.j));
        this.g.a(this.h, this.i);
    }

    public final void a(ArrayList<av> arrayList) {
        this.e.clear();
        this.d = 0;
        this.c = null;
        notifyDataSetChanged();
        if (arrayList != null && arrayList.size() != 0) {
            this.d = arrayList.size();
            this.c = arrayList;
            int i = 0;
            while (i < this.d) {
                HeadImageView headImageView = (HeadImageView) this.k.inflate(R.layout.carousel_topics_recommend_item, (ViewGroup) null);
                av avVar = arrayList.get(i);
                int i2 = i > 0 ? i - 1 : 0;
                headImageView.setTag(avVar.a());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.h, this.i));
                headImageView.setOnClickListener(new z(this, avVar, i2));
                this.a.add(headImageView);
                this.e.add(headImageView);
                i++;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.e.get(i);
        view.invalidate();
        viewGroup.addView(view);
        return view;
    }

    public final void a() {
        if (this.a != null && this.a.size() > 0) {
            Iterator<HeadImageView> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // com.baidu.tieba.view.bg
    public final void d() {
        if (this.g != null) {
            this.g.c();
        }
    }

    @Override // com.baidu.tieba.view.bg
    public final void a(View view, int i, int i2) {
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

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView;
        if (this.l != null && (headImageView = (HeadImageView) this.l.findViewWithTag(str)) != null && bVar != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
