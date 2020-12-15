package com.baidu.tieba.yuyinala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.baidu.live.liveroom.d.d;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private ArrayList<d> giT;
    private AlaRankListActivity oib;

    public AlaRankListFragmentAdapter(AlaRankListActivity alaRankListActivity, String str) {
        this.oib = alaRankListActivity;
        Wg(str);
    }

    private void Wg(String str) {
        this.giT = new ArrayList<>();
        this.giT.add(new com.baidu.tieba.yuyinala.b.a(this.oib, str));
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giT != null) {
            return this.giT.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.giT;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
