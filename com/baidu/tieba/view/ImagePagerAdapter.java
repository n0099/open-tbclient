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
    private Context f2482a;
    private ArrayList<String> b;
    private o e;
    private View.OnClickListener c = null;
    private p d = null;
    private int f = 0;
    private boolean g = false;
    private String h = null;
    private int i = 0;
    private boolean j = false;
    private boolean k = false;

    public ImagePagerAdapter(Context context, ArrayList<String> arrayList, o oVar) {
        this.f2482a = null;
        this.b = null;
        this.e = null;
        this.f2482a = context;
        this.b = arrayList;
        this.e = oVar;
    }

    public void a(ArrayList<String> arrayList) {
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

    public void a(p pVar) {
        this.d = pVar;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof bk) {
            ((bk) obj).c();
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.f2482a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.h);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            return inflate;
        }
        bk bkVar = new bk(this.f2482a);
        String str = i < this.b.size() ? this.b.get(i) : null;
        bkVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        bkVar.setImageOnClickListener(this.c);
        bkVar.setOnSizeChangedListener(this.d);
        ((ViewPager) viewGroup).addView(bkVar, 0);
        bkVar.a(str, this.j, this.k);
        bkVar.setGifMaxUseableMem(this.f);
        bkVar.setTag(String.valueOf(i));
        bkVar.setGifSetListener(this.e);
        return bkVar;
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof bk) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            k imageView = ((bk) obj).getImageView();
            if (galleryViewPager.getSelectedView() == null) {
                galleryViewPager.setSelectedView(imageView);
                ViewParent parent = galleryViewPager.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            k currentView = galleryViewPager.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((bk) obj).a(this.j, this.k);
                galleryViewPager.setCurrentView(imageView);
                if (((bk) obj).getImageType() == 1) {
                    this.e.a(imageView);
                }
            }
        }
    }

    public void b(boolean z) {
        this.j = z;
    }

    public void c(boolean z) {
        this.k = z;
    }
}
