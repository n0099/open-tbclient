package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.data.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaActiveBannerViewPagerAdapter extends PagerAdapter {
    private List<p> mOriginDatas;
    private b.a ohM;
    private List<p> mDatas = new ArrayList();
    private SimpleArrayMap<Integer, a> ohQ = new SimpleArrayMap<>();

    public void setData(List<p> list) {
        this.mOriginDatas = list;
        this.mDatas = new ArrayList();
        ListUtils.addAll(this.mDatas, 0, list);
        if (list.size() > 1) {
            this.mDatas.add(list.get(0));
            this.mDatas.add(0, list.get(list.size() - 1));
        }
    }

    public List<p> getOriginDatas() {
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
        a aVar = this.ohQ.get(Integer.valueOf(i));
        if (aVar == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyinala_active_view_item, (ViewGroup) null);
            aVar = new a(inflate, i);
            this.ohQ.put(Integer.valueOf(i), aVar);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaActiveBannerViewPagerAdapter.this.ohM != null) {
                        AlaActiveBannerViewPagerAdapter.this.ohM.b(viewGroup, view.getTag(a.f.ala_active_view_data), ((Integer) view.getTag(a.f.ala_active_view_position)).intValue());
                    }
                }
            });
            viewGroup.addView(aVar.getRootView(), 0);
        }
        Ls(i);
        if (this.ohM != null) {
            this.ohM.a(aVar.getRootView(), uV(i), i);
        }
        return aVar.getRootView();
    }

    public void Ls(int i) {
        p pVar = this.mDatas.get(i);
        if (this.ohM != null && pVar.aFk && this.ohM.va(pVar.aFt)) {
            pVar.aFk = false;
        }
        a aVar = this.ohQ.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.b(pVar);
        }
    }

    public p uV(int i) {
        if (this.mDatas == null || this.mDatas.size() <= i) {
            return null;
        }
        return this.mDatas.get(i);
    }

    public void a(b.a aVar) {
        this.ohM = aVar;
    }
}
