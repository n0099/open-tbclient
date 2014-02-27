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
public final class bh extends PagerAdapter {
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
        this.b = null;
        this.f = aaVar;
    }

    public final void a(ArrayList<String> arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void a(boolean z) {
        this.h = z;
        notifyDataSetChanged();
    }

    public final boolean a() {
        return this.h;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        int i = 0;
        if (this.b != null) {
            i = this.b.size();
            if (this.h) {
                i++;
            }
        }
        return i + this.j;
    }

    public final void a(int i) {
        this.j = i;
        notifyDataSetChanged();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.d = onLongClickListener;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void a(ab abVar) {
        this.e = abVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof cw) {
            ((cw) obj).a();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.i);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            inflate.setOnLongClickListener(this.d);
            return inflate;
        }
        cw cwVar = new cw(this.a);
        String str = i < this.b.size() ? this.b.get(i) : null;
        cwVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        cwVar.setImageOnClickListener(this.c);
        cwVar.setImageOnLongClickListener(this.d);
        cwVar.setIsCdn(this.k);
        cwVar.setOnSizeChangedListener(this.e);
        ((ViewPager) viewGroup).addView(cwVar, 0);
        cwVar.a(str, this.l);
        cwVar.setGifMaxUseableMem(this.g);
        cwVar.setTag(String.valueOf(i));
        cwVar.setGifSetListener(this.f);
        cwVar.setHeadImage(this.m);
        return cwVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof cw) {
            av avVar = (av) viewGroup;
            w imageView = ((cw) obj).getImageView();
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
                    currentView.n();
                }
                ((cw) obj).a(this.l);
                avVar.setCurrentView(imageView);
                if (((cw) obj).getImageType() == 1) {
                    this.f.a(imageView);
                }
            }
        }
    }

    public final void b(boolean z) {
        this.l = z;
    }

    public final void c(boolean z) {
        this.k = z;
    }

    public final void d(boolean z) {
        this.m = z;
    }
}
