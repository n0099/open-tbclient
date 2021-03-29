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
    public Context f26670a;

    /* renamed from: b  reason: collision with root package name */
    public List<View> f26671b;

    /* renamed from: c  reason: collision with root package name */
    public int f26672c = 0;

    public BCouponPagerAdapter(Context context, List<View> list) {
        this.f26671b = new ArrayList();
        this.f26670a = context;
        this.f26671b = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        List<View> list = this.f26671b;
        View view2 = list.get(i % list.size());
        if (view2.getParent() == null) {
            ((ViewPager) view).removeView(view2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f26671b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i = this.f26672c;
        if (i > 0) {
            this.f26672c = i - 1;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View view, int i) {
        List<View> list = this.f26671b;
        View view2 = list.get(i % list.size());
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
        this.f26672c = getCount();
        super.notifyDataSetChanged();
    }
}
