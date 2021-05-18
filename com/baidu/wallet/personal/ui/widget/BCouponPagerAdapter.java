package com.baidu.wallet.personal.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.apollon.NoProguard;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class BCouponPagerAdapter extends PagerAdapter implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public Context f26414a;

    /* renamed from: b  reason: collision with root package name */
    public List<View> f26415b;

    /* renamed from: c  reason: collision with root package name */
    public int f26416c = 0;

    public BCouponPagerAdapter(Context context, List<View> list) {
        this.f26415b = new ArrayList();
        this.f26414a = context;
        this.f26415b = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i2, Object obj) {
        List<View> list = this.f26415b;
        View view2 = list.get(i2 % list.size());
        if (view2.getParent() == null) {
            ((ViewPager) view).removeView(view2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f26415b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i2 = this.f26416c;
        if (i2 > 0) {
            this.f26416c = i2 - 1;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View view, int i2) {
        List<View> list = this.f26415b;
        View view2 = list.get(i2 % list.size());
        ViewParent parent = view2.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(view2);
        }
        ((ViewPager) view).addView(view2);
        return view2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        this.f26416c = getCount();
        super.notifyDataSetChanged();
    }
}
