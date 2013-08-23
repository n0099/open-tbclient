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
public class ImagePagerAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    private Context f1829a;
    private ArrayList b;
    private n e;
    private View.OnClickListener c = null;
    private o d = null;
    private int f = 0;
    private boolean g = false;
    private String h = null;
    private int i = 0;

    public ImagePagerAdapter(Context context, ArrayList arrayList, n nVar) {
        this.f1829a = null;
        this.b = null;
        this.e = null;
        this.f1829a = context;
        this.b = arrayList;
        this.e = nVar;
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
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.g;
    }

    @Override // android.support.v4.view.ae
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
        notifyDataSetChanged();
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(o oVar) {
        this.d = oVar;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof bf) {
            ((bf) obj).c();
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.f1829a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.h);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            return inflate;
        }
        bf bfVar = new bf(this.f1829a);
        String str = i < this.b.size() ? (String) this.b.get(i) : null;
        bfVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        bfVar.setImageOnClickListener(this.c);
        bfVar.setOnSizeChangedListener(this.d);
        ((ViewPager) viewGroup).addView(bfVar, 0);
        bfVar.setUrl(str);
        bfVar.setGifMaxUseableMem(this.f);
        bfVar.setTag(String.valueOf(i));
        bfVar.setGifSetListener(this.e);
        return bfVar;
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof bf) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            j imageView = ((bf) obj).getImageView();
            if (galleryViewPager.getSelectedView() == null) {
                galleryViewPager.setSelectedView(imageView);
                ViewParent parent = galleryViewPager.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            j currentView = galleryViewPager.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((bf) obj).f();
                galleryViewPager.setCurrentView(imageView);
                if (((bf) obj).getImageType() == 1) {
                    this.e.a(imageView);
                }
            }
        }
    }
}
