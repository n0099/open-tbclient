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
    private Context a;
    private ArrayList<String> b;
    private y f;
    private View.OnClickListener c = null;
    private View.OnLongClickListener d = null;
    private z e = null;
    private int g = 0;
    private boolean h = false;
    private String i = null;
    private int j = 0;
    private boolean k = false;
    private boolean l = false;

    public ImagePagerAdapter(Context context, ArrayList<String> arrayList, y yVar) {
        this.a = null;
        this.b = null;
        this.f = null;
        this.a = context;
        this.b = arrayList;
        this.f = yVar;
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

    @Override // android.support.v4.view.ae
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

    public void a(z zVar) {
        this.e = zVar;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof cq) {
            ((cq) obj).c();
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.i);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            inflate.setOnLongClickListener(this.d);
            return inflate;
        }
        cq cqVar = new cq(this.a);
        String str = i < this.b.size() ? this.b.get(i) : null;
        cqVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        cqVar.setImageOnClickListener(this.c);
        cqVar.setImageOnLongClickListener(this.d);
        cqVar.setIsCdn(this.k);
        cqVar.setOnSizeChangedListener(this.e);
        ((ViewPager) viewGroup).addView(cqVar, 0);
        cqVar.a(str, this.l);
        cqVar.setGifMaxUseableMem(this.g);
        cqVar.setTag(String.valueOf(i));
        cqVar.setGifSetListener(this.f);
        return cqVar;
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof cq) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            u imageView = ((cq) obj).getImageView();
            if (galleryViewPager.getSelectedView() == null) {
                galleryViewPager.setSelectedView(imageView);
                ViewParent parent = galleryViewPager.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            u currentView = galleryViewPager.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((cq) obj).a(this.l);
                galleryViewPager.setCurrentView(imageView);
                if (((cq) obj).getImageType() == 1) {
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
}
