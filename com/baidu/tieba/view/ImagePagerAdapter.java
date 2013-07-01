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
    private Context f1491a;
    private ArrayList b;
    private l e;
    private View.OnClickListener c = null;
    private m d = null;
    private int f = 0;
    private boolean g = false;
    private String h = null;
    private int i = 0;

    public ImagePagerAdapter(Context context, ArrayList arrayList, l lVar) {
        this.f1491a = null;
        this.b = null;
        this.e = null;
        this.f1491a = context;
        this.b = arrayList;
        this.e = lVar;
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
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(m mVar) {
        this.d = mVar;
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof aq) {
            ((aq) obj).c();
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.f1491a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.h);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            return inflate;
        }
        aq aqVar = new aq(this.f1491a);
        String str = i < this.b.size() ? (String) this.b.get(i) : null;
        aqVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        aqVar.setImageOnClickListener(this.c);
        aqVar.setOnSizeChangedListener(this.d);
        ((ViewPager) viewGroup).addView(aqVar, 0);
        aqVar.setUrl(str);
        aqVar.setGifMaxUseableMem(this.f);
        aqVar.setTag(String.valueOf(i));
        aqVar.setGifSetListener(this.e);
        return aqVar;
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof aq) {
            GalleryViewPager galleryViewPager = (GalleryViewPager) viewGroup;
            h imageView = ((aq) obj).getImageView();
            if (galleryViewPager.getSelectedView() == null) {
                galleryViewPager.setSelectedView(imageView);
                ViewParent parent = galleryViewPager.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            h currentView = galleryViewPager.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((aq) obj).f();
                galleryViewPager.setCurrentView(imageView);
                if (((aq) obj).getImageType() == 1) {
                    this.e.a(imageView);
                }
            }
        }
    }
}
