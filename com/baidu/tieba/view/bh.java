package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bh extends PagerAdapter {
    private Context a;
    private ArrayList<String> b;
    private aa f;
    private boolean m;
    private View.OnClickListener c = null;
    private View.OnLongClickListener d = null;
    private ab e = null;
    private int g = 0;
    private boolean h = false;
    private String i = null;
    private int j = 0;
    private boolean k = false;
    private boolean l = false;

    public bh(Context context, ArrayList<String> arrayList, aa aaVar) {
        this.a = null;
        this.b = null;
        this.f = null;
        this.a = context;
        this.b = arrayList;
        this.f = aaVar;
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.h = z;
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.h;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.b != null) {
            i = this.b.size();
            if (this.h) {
                i++;
            }
        }
        return i + this.j;
    }

    public void a(int i) {
        this.j = i;
        notifyDataSetChanged();
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.d = onLongClickListener;
    }

    public void b(int i) {
        this.g = i;
    }

    public void a(ab abVar) {
        this.e = abVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof cx) {
            ((cx) obj).c();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.i);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            inflate.setOnLongClickListener(this.d);
            return inflate;
        }
        cx cxVar = new cx(this.a);
        String str = i < this.b.size() ? this.b.get(i) : null;
        cxVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        cxVar.setImageOnClickListener(this.c);
        cxVar.setImageOnLongClickListener(this.d);
        cxVar.setIsCdn(this.k);
        cxVar.setOnSizeChangedListener(this.e);
        ((ViewPager) viewGroup).addView(cxVar, 0);
        cxVar.a(str, this.l);
        cxVar.setGifMaxUseableMem(this.g);
        cxVar.setTag(String.valueOf(i));
        cxVar.setGifSetListener(this.f);
        cxVar.setHeadImage(this.m);
        return cxVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof cx) {
            av avVar = (av) viewGroup;
            w imageView = ((cx) obj).getImageView();
            if (avVar.getSelectedView() == null) {
                avVar.setSelectedView(imageView);
                ViewParent parent = avVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            w currentView = avVar.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((cx) obj).a(this.l);
                avVar.setCurrentView(imageView);
                if (((cx) obj).getImageType() == 1) {
                    this.f.a(imageView);
                }
            }
        }
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void c(boolean z) {
        this.k = z;
    }

    public void d(boolean z) {
        this.m = z;
    }
}
