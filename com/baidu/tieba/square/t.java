package com.baidu.tieba.square;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t extends PagerAdapter implements com.baidu.tbadk.imageManager.d, com.baidu.tieba.view.u {
    final /* synthetic */ q b;
    private Context f;
    private int g;
    private int h;
    private LayoutInflater j;
    private View k;
    private ArrayList<ap> c = null;
    private int d = 0;
    private ArrayList<View> e = new ArrayList<>();
    public ArrayList<HeadImageView> a = new ArrayList<>();
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

    private void a(HeadImageView headImageView, ap apVar, int i) {
        headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.g, this.h));
        headImageView.a(apVar.a(), 10, false);
        headImageView.setOnClickListener(new u(this, apVar, i));
        this.a.add(headImageView);
    }

    public void a(ArrayList<ap> arrayList) {
        a();
        if (arrayList != null && arrayList.size() != 0) {
            this.d = arrayList.size();
            this.c = arrayList;
            int i = 0;
            while (i < this.d) {
                HeadImageView headImageView = (HeadImageView) this.j.inflate(com.baidu.tieba.w.carousel_topics_recommend_item, (ViewGroup) null);
                a(headImageView, arrayList.get(i), i > 0 ? i - 1 : 0);
                this.e.add(headImageView);
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

    @Override // com.baidu.tieba.view.u
    public void b() {
    }

    @Override // com.baidu.tieba.view.u
    public void a(View view, int i, int i2) {
        this.k = view;
        if (this.c != null) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                String a = this.c.get(i3).a();
                if (this.k != null) {
                    HeadImageView headImageView = (HeadImageView) this.k.findViewWithTag(a);
                    headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
                    headImageView.a(a, 10, this.g, this.h, false);
                }
            }
        }
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
