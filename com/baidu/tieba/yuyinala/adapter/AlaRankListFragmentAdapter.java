package com.baidu.tieba.yuyinala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> gaG;
    private AlaRankListActivity nTb;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.nTb = alaRankListActivity;
        UR(str);
    }

    private void UR(String str) {
        this.gaG = new ArrayList<>();
        this.gaG.add(new com.baidu.tieba.yuyinala.b.a(this.nTb, str));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gaG != null) {
            return this.gaG.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gaG;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
