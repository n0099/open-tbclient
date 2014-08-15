package com.baidu.tieba.square;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t extends PagerAdapter implements com.baidu.tbadk.imageManager.d, com.baidu.tieba.view.s {
    final /* synthetic */ q b;
    private Context f;
    private int g;
    private int h;
    private LayoutInflater j;
    private View k;
    private ArrayList<ap> c = null;
    private int d = 0;
    private ArrayList<View> e = new ArrayList<>();
    public ArrayList<TbImageView> a = new ArrayList<>();
    private float i = 0.46875f;

    public t(q qVar, Context context) {
        this.b = qVar;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.j = null;
        this.f = context;
        this.j = LayoutInflater.from(context);
        this.g = com.baidu.adp.lib.util.j.b(context);
        this.h = (int) (0.5f + (this.g * this.i));
    }

    private void a(TbImageView tbImageView, ap apVar, int i) {
        tbImageView.a(apVar.a(), 10, this.g, this.h, false);
        tbImageView.setLayoutParams(new ViewGroup.LayoutParams(this.g, this.h));
        tbImageView.setOnClickListener(new u(this, apVar, tbImageView, i));
        this.a.add(tbImageView);
    }

    public void a(ArrayList<ap> arrayList) {
        boolean z;
        a();
        if (arrayList != null && arrayList.size() != 0) {
            this.d = arrayList.size();
            this.c = arrayList;
            int i = 0;
            while (i < this.d) {
                TbImageView tbImageView = (TbImageView) this.j.inflate(com.baidu.tieba.v.carousel_topics_recommend_item, (ViewGroup) null);
                z = this.b.m;
                if (!z) {
                    tbImageView.setDrawerType(1);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setDrawBorder(true);
                }
                a(tbImageView, arrayList.get(i), i > 0 ? i - 1 : 0);
                this.e.add(tbImageView);
                i++;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.e.get(i);
        view.setTag(Integer.valueOf(i));
        view.invalidate();
        viewGroup.addView(view);
        return view;
    }

    public void a(int i) {
        if (this.a != null && this.a.size() > 0) {
            Iterator<TbImageView> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private void a() {
        this.e.clear();
        this.d = 0;
        this.c = null;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.view.s
    public void b() {
    }

    @Override // com.baidu.tieba.view.s
    public void a(View view, int i, int i2) {
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView;
        if (this.k != null && (headImageView = (HeadImageView) this.k.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
            headImageView.invalidate();
        }
    }
}
