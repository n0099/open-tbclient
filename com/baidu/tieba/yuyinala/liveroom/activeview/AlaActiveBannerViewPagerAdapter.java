package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.data.t;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private List<t> mOriginDatas;
    private b.a oul;
    private List<t> mDatas = new ArrayList();
    private SimpleArrayMap<Integer, a> oup = new SimpleArrayMap<>();

    public void setData(List<t> list) {
        this.mOriginDatas = list;
        this.mDatas = new ArrayList();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public List<t> eaH() {
        return this.mOriginDatas;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mDatas);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, int i) {
        a aVar = this.oup.get(Integer.valueOf(i));
        if (aVar == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyinala_active_view_item, (ViewGroup) null);
            aVar = new a(inflate, i);
            this.oup.put(Integer.valueOf(i), aVar);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveBannerViewPagerAdapter.this.oul != null) {
                        AlaActiveBannerViewPagerAdapter.this.oul.b(viewGroup, view.getTag(a.f.ala_active_view_data), ((Integer) view.getTag(a.f.ala_active_view_position)).intValue());
                    }
                }
            });
            viewGroup.addView(aVar.getRootView(), 0);
        }
        LS(i);
        if (this.oul != null) {
            this.oul.a(aVar.getRootView(), vi(i), i);
        }
        return aVar.getRootView();
    }

    public void LS(int i) {
        t tVar = this.mDatas.get(i);
        if (this.oul != null && tVar.aJg && this.oul.vn(tVar.aJp)) {
            tVar.aJg = false;
        }
        a aVar = this.oup.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.b(tVar);
        }
    }

    public t vi(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.oul = aVar;
    }
}
