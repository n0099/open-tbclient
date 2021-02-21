package com.baidu.tieba.recommendlist.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
/* loaded from: classes11.dex */
public class RecommendPagerAdapter extends PagerAdapter {
    private List<View> nbg;

    public RecommendPagerAdapter(List<View> list) {
        this.nbg = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.nbg.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.nbg.get(i));
        return this.nbg.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.nbg.get(i));
    }
}
