package com.baidu.tieba.yuyinala.liveroom.recommend.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendPagerAdapter extends PagerAdapter {
    private List<View> mBU;

    public RecommendPagerAdapter(List<View> list) {
        this.mBU = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mBU.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.mBU.get(i));
        return this.mBU.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.mBU.get(i));
    }
}
