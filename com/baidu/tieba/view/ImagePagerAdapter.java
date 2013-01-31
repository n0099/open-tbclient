package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends android.support.v4.view.k {
    private Context a;
    private ArrayList b;
    private j e;
    private View.OnClickListener c = null;
    private k d = null;
    private int f = 0;
    private boolean g = false;
    private String h = null;

    public ImagePagerAdapter(Context context, ArrayList arrayList, j jVar) {
        this.a = null;
        this.b = null;
        this.e = null;
        this.a = context;
        this.b = arrayList;
        this.e = jVar;
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

    @Override // android.support.v4.view.k
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        int size = this.b.size();
        if (this.g) {
            return size + 1;
        }
        return size;
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(k kVar) {
        this.d = kVar;
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.k
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ah) {
            ((ah) obj).c();
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
        ah ahVar = new ah(this.a);
        String str = i < this.b.size() ? (String) this.b.get(i) : null;
        ahVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        ahVar.setImageOnClickListener(this.c);
        ahVar.setOnSizeChangedListener(this.d);
        ((ViewPager) viewGroup).addView(ahVar, 0);
        ahVar.setUrl(str);
        ahVar.setGifMaxUseableMem(this.f);
        ahVar.setTag(String.valueOf(i));
        ahVar.setGifSetListener(this.e);
        return ahVar;
    }

    @Override // android.support.v4.view.k
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ah) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            f imageView = ((ah) obj).getImageView();
            if (galleryViewPager.getSelectedView() == null) {
                galleryViewPager.setSelectedView(imageView);
                ViewParent parent = galleryViewPager.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            f currentView = galleryViewPager.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((ah) obj).f();
                galleryViewPager.setCurrentView(imageView);
                if (((ah) obj).getImageType() == 1) {
                    this.e.a(imageView);
                }
            }
        }
    }
}
