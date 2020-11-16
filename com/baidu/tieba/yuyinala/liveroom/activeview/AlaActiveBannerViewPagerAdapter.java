package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private List<o> mOriginDatas;
    private b.a nVD;
    private List<o> mDatas = new ArrayList();
    private SimpleArrayMap<Integer, a> nVG = new SimpleArrayMap<>();

    public void setData(List<o> list) {
        this.mOriginDatas = list;
        this.mDatas = new ArrayList();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public List<o> getOriginDatas() {
        return this.mOriginDatas;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.mDatas);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, int i) {
        a aVar = this.nVG.get(Integer.valueOf(i));
        if (aVar == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyinala_active_view_item, (ViewGroup) null);
            aVar = new a(inflate, i);
            this.nVG.put(Integer.valueOf(i), aVar);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveBannerViewPagerAdapter.this.nVD != null) {
                        AlaActiveBannerViewPagerAdapter.this.nVD.c(viewGroup, view.getTag(a.f.ala_active_view_data), ((Integer) view.getTag(a.f.ala_active_view_position)).intValue());
                    }
                }
            });
            viewGroup.addView(aVar.getRootView(), 0);
        }
        Mw(i);
        if (this.nVD != null) {
            this.nVD.b(aVar.getRootView(), vL(i), i);
        }
        return aVar.getRootView();
    }

    public void Mw(int i) {
        o oVar = this.mDatas.get(i);
        if (this.nVD != null && oVar.aGO && this.nVD.vQ(oVar.aGX)) {
            oVar.aGO = false;
        }
        a aVar = this.nVG.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.b(oVar);
        }
    }

    public o vL(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.nVD = aVar;
    }
}
