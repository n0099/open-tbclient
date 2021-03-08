package com.baidu.tieba.yuyinala.liveroom.recommend.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
/* loaded from: classes10.dex */
public class RecommendPagerAdapter extends PagerAdapter {
    private List<View> ndk;

    public RecommendPagerAdapter(List<View> list) {
        this.ndk = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.ndk.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.ndk.get(i));
        return this.ndk.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.ndk.get(i));
    }
}
