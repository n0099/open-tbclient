package com.baidu.tieba.yuyinala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> gaZ;
    private AlaRankListActivity nRy;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.nRy = alaRankListActivity;
        Vg(str);
    }

    private void Vg(String str) {
        this.gaZ = new ArrayList<>();
        this.gaZ.add(new com.baidu.tieba.yuyinala.b.a(this.nRy, str));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gaZ != null) {
            return this.gaZ.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gaZ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
