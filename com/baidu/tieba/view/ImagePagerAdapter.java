package com.baidu.tieba.view;

import android.content.Context;
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
public class ImagePagerAdapter extends android.support.v4.view.k {
    private Context a;
    private ArrayList b;
    private k e;
    private View.OnClickListener c = null;
    private l d = null;
    private int f = 0;
    private boolean g = false;
    private String h = null;
    private int i = 0;

    public ImagePagerAdapter(Context context, ArrayList arrayList, k kVar) {
        this.a = null;
        this.b = null;
        this.e = null;
        this.a = context;
        this.b = arrayList;
        this.e = kVar;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean a() {
        return this.g;
    }

    @Override // android.support.v4.view.k
    public int getCount() {
        int i = 0;
        if (this.b != null) {
            i = this.b.size();
            if (this.g) {
                i++;
            }
        }
        return i + this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(l lVar) {
        this.d = lVar;
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.k
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ap) {
            ((ap) obj).c();
        }
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.h);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            return inflate;
        }
        ap apVar = new ap(this.a);
        String str = i < this.b.size() ? (String) this.b.get(i) : null;
        apVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        apVar.setImageOnClickListener(this.c);
        apVar.setOnSizeChangedListener(this.d);
        ((ViewPager) viewGroup).addView(apVar, 0);
        apVar.setUrl(str);
        apVar.setGifMaxUseableMem(this.f);
        apVar.setTag(String.valueOf(i));
        apVar.setGifSetListener(this.e);
        return apVar;
    }

    @Override // android.support.v4.view.k
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ap) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            g imageView = ((ap) obj).getImageView();
            if (galleryViewPager.getSelectedView() == null) {
                galleryViewPager.setSelectedView(imageView);
                ViewParent parent = galleryViewPager.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            g currentView = galleryViewPager.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((ap) obj).f();
                galleryViewPager.setCurrentView(imageView);
                if (((ap) obj).getImageType() == 1) {
                    this.e.a(imageView);
                }
            }
        }
    }
}
